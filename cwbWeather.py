# -*- coding: utf-8 -*-
"""

中央氣象局 open data.

Created on Wed Oct 26 21:04:43 2022

@author: 徐子陵
"""
import requests, json, datetime
import requests.packages.urllib3

CWB_AUTHED_KEY = 'CWB-52F7E175-5DC9-4E41-9D16-6ED798D0C27E'

TAIWAN_CITY = {'宜蘭縣':'F-D0047-001',
    '桃園市':'F-D0047-005',
    '新竹縣':'F-D0047-009',
    '苗栗縣':'F-D0047-013',
    '彰化縣':'F-D0047-017',
    '南投縣':'F-D0047-021',
    '雲林縣':'F-D0047-025',
    '嘉義縣':'F-D0047-029',
    '屏東縣':'F-D0047-033',
    '臺東縣':'F-D0047-037',
    '花蓮縣':'F-D0047-041',
    '澎湖縣':'F-D0047-045',
    '基隆市':'F-D0047-049',
    '新竹市':'F-D0047-053',
    '嘉義市':'F-D0047-057',
    '臺北市':'F-D0047-061',
    '高雄市':'F-D0047-065',
    '新北市':'F-D0047-069',
    '臺中市':'F-D0047-073',
    '臺南市':'F-D0047-077',
    '連江縣':'F-D0047-081',
    '金門縣':'F-D0047-085'}

cwb_headers = {
       'accept-encoding': 'gzip, deflate, br', 
       'accept-language': 'zh-TW,zh;q=0.9,en-US;q=0.8,en;q=0.7', 
       'Cache-Control': 'no-cache',
       'pragma': 'no-cache',
       'Upgrade-Insecure-Requests': '1',
       'user-agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36',
       'content-type': 'application/x-www-form-urlencoded',
       'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
       'cookie':''
    }

def get_taiwan_weather(area,uid):
    """
    Get current weather in specific city.

    Args:
        city: City Name

    Returns:
        Line TextSendMessage
    """ 
    '''https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-52F7E175-5DC9-4E41-9D16-6ED798D0C27E
        &locationName=%E5%AE%9C%E8%98%AD%E7%B8%A3,%E8%8A%B1%E8%93%AE%E7%B8%A3&sort=time&timeFrom=2021-11-14T06%3A00%3A00&timeTo=2021-11-14T08%3A00%3A00
    '''
    print('area:'+area) 
    
    apiNm = 'F-C0032-001'
    now = datetime.datetime.now()
    timeFrom = '2022-10-29T06:00:00'
    timeTo = '2022-10-29T18:00:00'
    city = []
    msg = []

    if area[0] == u'台':
        area = u'臺' + area[1:];
    
    if area[-2:] == u'天氣':
        area = area[:-2]
    
    if area[-1] == u'縣' or area[-1] == u'市':
        city = [area]
    else:
        if area == u'雙北':
            city = [u'臺北市',u'新北市']
        elif area == u'離島':
            city = [u'澎湖縣',u'金門縣',u'連江縣']
        elif area == u'雙北離島':
            city = [u'臺北市',u'新北市',u'澎湖縣',u'金門縣',u'連江縣']
        elif area == u'東部':
            city = [u'宜蘭縣',u'花蓮縣',u'臺東縣']
        else:
            for name in TAIWAN_CITY.keys():
                if name[:-1] == area:
                    city.append(name)
                #end if
            #end loop
    #end if
    
    if len(city) == 0:
        return u'目前的{}無任何天氣資料。'.format(area)
    if now.hour > 4:
        timeFrom = '{}T06:00:00'.format(now.strftime("%Y-%m-%d"))
        timeTo = '{}T18:00:00'.format(now.strftime("%Y-%m-%d"))
    elif now.hour > 22 or now.hour < 5:
        now += datetime.timedelta(days=1)
        timeFrom = '{}T06:00:00'.format(now.strftime("%Y-%m-%d"))
        timeTo = '{}T18:00:00'.format(now.strftime("%Y-%m-%d"))
    else:
        timeTo = '{}T06:00:00'.format(now.strftime("%Y-%m-%d"))
        now -= datetime.timedelta(days=1)
        timeFrom = '{}T18:00:00'.format(now.strftime("%Y-%m-%d"))

    url = 'https://opendata.cwb.gov.tw/api/v1/rest/datastore/{}?Authorization={}' \
        '&locationName={}&sort=time&timeFrom={}&timeTo={}'.format(apiNm, CWB_AUTHED_KEY, ','.join(city), timeFrom, timeTo)
    
    requests.packages.urllib3.disable_warnings()
    resp = requests.get(url, headers=cwb_headers, verify=False)
    if resp.status_code != 200:
        print('Invalid url:', resp.status_code)
        return "Invalid url: {}".format(resp.status_code)
    
    tww = json.loads(resp.text)
    
    if tww['success'] != 'true':
        return "json.loads fail."
        
    wWx = ''
    wPop = ''
    wMinT = ''
    wCT = ''
    wMaxT = ''
    records = tww['records']
    location = records['location']
    for loc in location:
        # If the city is found, access its child direct.
        weatherElement = loc['weatherElement']
        for wElm in weatherElement:
            eN = wElm['elementName']
            wtime = wElm['time']
            if eN == 'Wx':
                wWx = wtime[0]['parameter']['parameterName']
            elif eN == 'PoP':
                wPop = wtime[0]['parameter']['parameterName']
            elif eN == 'MinT':
                wMinT = wtime[0]['parameter']['parameterName']
            elif eN == 'CT':
                wCT = wtime[0]['parameter']['parameterName']
            elif eN == 'MaxT':
                wMaxT = wtime[0]['parameter']['parameterName']
            #end if
        #end loop
        msg.append(u'%s目前的天氣為%s。\n溫度為 %s 至 %s ℃，降雨機率為 %s %%。\n %s' % (loc['locationName'], wWx, wMinT, wMaxT, wPop, wCT))
    #end loop
    
    return dict({'uid': uid, 'type':'text', 'content':"\n".join(msg)})



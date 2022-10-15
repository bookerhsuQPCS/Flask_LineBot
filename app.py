# -*- coding: utf-8 -*-
"""
Line ChatBot
Created on Sat Nov 18 21:00:17 21

@author: bookerhsu
"""

import requests, re, feedparser, random, time, os
import json, datetime, pysnooper, threading
import requests.packages.urllib3
from bs4 import BeautifulSoup
from flask import Flask, request, abort
from concurrent.futures import ThreadPoolExecutor

from linebot import (
    LineBotApi, WebhookHandler
)

from linebot.exceptions import (
    InvalidSignatureError
)

from linebot.models import (
    MessageEvent, TextMessage, TextSendMessage, ImageSendMessage,
    SourceUser, SourceGroup, SourceRoom, Sender,
    TemplateSendMessage, ConfirmTemplate, MessageAction,
    ButtonsTemplate, ImageCarouselTemplate, ImageCarouselColumn, URIAction,
    PostbackAction, DatetimePickerAction,
    URITemplateAction, MessageTemplateAction, PostbackTemplateAction,
    CameraAction, CameraRollAction, LocationAction,
    CarouselTemplate, CarouselColumn, PostbackEvent,
    StickerMessage, StickerSendMessage, LocationMessage, LocationSendMessage,
    ImageMessage, VideoMessage, AudioMessage, FileMessage,
    UnfollowEvent, FollowEvent, JoinEvent, LeaveEvent, BeaconEvent,
    FlexSendMessage, BubbleContainer, ImageComponent, BoxComponent,
    TextComponent, IconComponent, ButtonComponent,
    SeparatorComponent, QuickReply, QuickReplyButton
)

app = Flask(__name__)

# 必須放上自己的Channel Access Token
line_bot_api = LineBotApi(os.environ['CHANNEL_ACCESS_TOKEN'])

# 必須放上自己的Channel Secret
handler = WebhookHandler(os.environ['CHANNEL_SECRET'])

is_buy = False

#category
category_set = ('1900000000',
        '2900000000',
        '2000000000',
        '1300000000',
        '1400000000',
        '1500000000',
        '1700000000',
        '2500000000',
        '2700000000',
        '1800000000',
        '1600000000',
        '4000000000',
        '4100000000',
        '3500000000',
        '2400000000',
        '1100000000',
        '1200000000',
        '2000000000',
        '1300000000',
        '1400000000',
        '4000000000',
        '4100000000',
        '3500000000')

girl_img_urls = []

mm_headers = {
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

executor = ThreadPoolExecutor(3)

requests.packages.urllib3.disable_warnings()

headers = {
        'Authorization': CWB_AUTHED_KEY, 
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'
    }

# my background thread
class MyPePe():

    def __init__(self, message):
        self.message = message
        
        thread = threading.Thread(target=self.run, args=())
        thread.daemon = True
        thread.start()

    def run(self):
        time.sleep(10)
        print(f'run MyWorker with parameter {self.message}')

def get_news(userid):
    """
    建立一個抓最新消息的function
    """
    print('uid: '+userid)
    rss_url = 'http://feeds.feedburner.com/cnaFirstNews'
    # 抓取資料
    rss = feedparser.parse(rss_url)
    tmp = []
    for i, entry in enumerate(rss.entries[:5], start=0):
        tmp.append(entry['title'] + ' ' + entry['link'])
    #end if
    
    if (len(tmp)>0):
        message =TextSendMessage("\n".join(tmp))
        line_bot_api.push_message(userid, message)
    #end if
    print('get_news_push: end')

def get_current_weather(keyword, userid):
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
    # print('uid: '+userid)
    # print('keyword:'+keyword) 
    
    errMsg = u'目前的 {} 無任何資料。'.format(keyword)
    apiNm = 'F-C0032-001'
    now = datetime.datetime.now()
    timeFrom = '2021-11-14T06:00:00'
    timeTo = '2021-11-14T18:00:00'
    city = []
    msg = []

    if keyword[0] == u'台':
        keyword = u'臺' + keyword[1:];
    
    if keyword[-2:] == u'天氣':
        keyword = keyword[:-2]
    
    if keyword[-1] == u'縣' or keyword[-1] == u'市':
        city = [keyword]
    else:
        if keyword == u'雙北':
            city = [u'臺北市',u'新北市']
        elif keyword == u'離島':
            city = [u'澎湖縣',u'金門縣',u'連江縣']
        elif keyword == u'東部':
            city = [u'宜蘭縣',u'花蓮縣',u'臺東縣']
        else:
            for name in TAIWAN_CITY.keys():
                if name[:-1] == keyword:
                    city.append(name)
                #end if
            #end loop
    #end if
    
    if len(city) == 0:
        line_bot_api.push_message(userid, TextSendMessage(text=errMsg))
        return
    
    print(now)
    
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
    
    resp = requests.get(url, headers=headers, verify=False)
    if resp.status_code != 200:
        print('Invalid url:', resp.status_code)
        line_bot_api.push_message(userid, TextSendMessage(text=errMsg))
        return
    
    tww = json.loads(resp.text)
    
    if tww['success'] != 'true':
        line_bot_api.push_message(userid, TextSendMessage(text=errMsg))
        return
        
    wWx = ''
    wPop = ''
    wMinT = ''
    wCT = ''
    wMaxT = ''
    records = tww['records']
    location = records['location']
    for loc in location:
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
        msg.append('%s目前的天氣為%s。\n溫度為 %s 至 %s ℃，降雨機率為 %s %%。\n %s' % (loc['locationName'], wWx, wMinT, wMaxT, wPop, wCT))
    #end loop

    line_bot_api.push_message(userid, TextSendMessage(text='\n'.join(msg)))

def get_momo_search(keyword,userid):
    print('uid: '+userid)
    print('keyword:'+keyword)           
    target_url = 'https://m.momoshop.com.tw/search.momo?searchKeyword={}&couponSeq=&searchType=1&cateLevel=-1&ent=k&_imgSH=fourCardStyle'.format(keyword)
    print(target_url)
    
    # handle request body
    try:
        requests.packages.urllib3.disable_warnings()
        resp = requests.get(url=target_url, headers=mm_headers, timeout=15)
    except requests.exceptions.Timeout as tim:
        # Maybe set up for a retry, or continue in a retry loop
        print(tim)
        return
    except requests.exceptions.TooManyRedirects as man:
        # Tell the user their URL was bad and try a different one
        print(man)
        return
    except requests.exceptions.RequestException as e:
        # catastrophic error. bail.
        print(e)
        return
    except requests.exceptions.HTTPError as err:
        print(err)
        return
 
    soup = BeautifulSoup(resp.text,"lxml")
    _carouse_columns = []

    prdListArea = soup.find("article", class_="prdListArea")
    if prdListArea is not None:
        _li_a = prdListArea.find_all('li', class_='goodsItemLi')
        for idx, _li in enumerate(_li_a[:10], start=0):
            _a = _li.find('a')
            img  = _a.find('div',class_='swiper-wrapper').find('img')
            _title = img['title']
            match = re.search(r'【.+】(.+)', _title)
            if match is not None:
                _title = match.group(1)
            #end if
            
            img_url = 'https:{}'.format(img['src']) if 'http' not in img['src'] else img['src']
            img_url = img_url.replace('.webp','.jpg')
    
            _carouse_columns.append(CarouselColumn(
                    thumbnail_image_url=img_url,
                    text=_title,
                    actions=[
                        URITemplateAction(
                            label='去逛逛',
                            uri=('https://m.momoshop.com.tw'+_a['href']) if 'http' not in _a['href'] else _a['href']
                        )
                    ]
                )
            )
    
        #end for
    
        message = TemplateSendMessage(
            alt_text='Carousel template',
            template=CarouselTemplate(
                columns=_carouse_columns
            )
        )
    
        line_bot_api.push_message(userid, message)
    #end if
    print('getmomo_search_push:end')

def get_momo_top30(category,userid):
    print('uid: '+userid)
    print('category:'+category)
    target_url = 'https://m.momoshop.com.tw/category.momo?cn={}&top30New=y'.format(category)
    
    # handle request body
    try:
        requests.packages.urllib3.disable_warnings()
        resp = requests.get(url=target_url, headers=mm_headers, timeout=15)
    except requests.exceptions.Timeout as tim:
        # Maybe set up for a retry, or continue in a retry loop
        print(tim)
        return
    except requests.exceptions.TooManyRedirects as man:
        # Tell the user their URL was bad and try a different one
        print(man)
        return
    except requests.exceptions.RequestException as e:
        # catastrophic error. bail.
        print(e)
        return
    except requests.exceptions.HTTPError as err:
        print(err)
        return
 
    soup = BeautifulSoup(resp.text,"lxml")
    _cn = category
    _carouse_columns = []
    pathArea = soup.find("article", class_="pathArea")
    if pathArea is not None and len(pathArea) > 0:
        _cn = pathArea.find("a", attrs={"cn": category}).text
    #end if

    productInfo = soup.find_all("a", class_="productInfo")
    if productInfo is not None and len(productInfo) > 0:
        for pd in productInfo[:10]:
            prdImgWrap = pd.find("div", class_="prdImgWrap")
            if prdImgWrap is not None:
                act = prdImgWrap.find("div", class_="swiper-slide-active")
                if act is None:
                    act = prdImgWrap.find_all("div", class_="swiper-slide", limit=1)[0]
                #end if
                img = act.find("img")
                _alt = img['alt']
                img_url = img['data-original'] if 'http' in img['data-original'] else 'https://m.momoshop.com.tw{}'.format(img['data-original'])
                img_url = img_url.replace('.webp','.jpg')
                
                _column = CarouselColumn(
                    thumbnail_image_url=img_url,
                    text=_alt,
                    actions=[
                        URITemplateAction(
                            label='去看看',
                            uri=pd['href'] if 'http' in pd['href'] else 'https://m.momoshop.com.tw{}'.format(pd['href'])
                        )
                    ]
                )
                _carouse_columns.append(_column)
            #end if
        # end loop
        
        print(_carouse_columns)
       
        msg = TemplateSendMessage(
            alt_text='{} TOP30'.format(_cn),
            imageAspectRatio='square',
            imageSize='contain',
            template=CarouselTemplate(
                columns=_carouse_columns
            )
        )

        line_bot_api.push_message(userid, msg)
    #end if
    print('getmomo_top30_push: end')

def load_image_url():
    _img_urls = []
    print('load_image_url()')

    with open("/app/girl_img_urls.lst", "r") as f:
        _img_urls.append(f.read())
   
    return _img_urls

######################################################

@pysnooper.snoop()
def get_stock_info(stock_id,userid):
    headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) '
                             'AppleWebKit/537.36 (KHTML, like Gecko) '
                             'Chrome/66.0.3359.181 Safari/537.36',
                             "Accept-Language":"zh-TW,zh;q=0.8"}
    resp = requests.get('https://www.google.com/search?q=TPE:{}'.format(stock_id), headers=headers)
    if resp.status_code != 200:
        print('Invalid url:', resp.url)
        return None

    soup = BeautifulSoup(resp.text, 'html.parser')
    stock = dict()

    sections = soup.find_all('g-card-section')

    # 第 2 個 g-card-section, 取出公司名及即時股價資訊
    stock['name'] = sections[1].div.text
    spans = sections[1].find_all('div', recursive=False)[1].find_all('span', recursive=False)
    stock['current_price'] = spans[0].text
    stock['current_change'] = spans[1].text

    # 第 4 個 g-card-section, 有左右兩個 table 分別存放股票資訊
    for table in sections[3].find_all('table'):
        for tr in table.find_all('tr')[:3]:
            key = tr.find_all('td')[0].text.lower().strip()
            value = tr.find_all('td')[1].text.strip()
            stock[key] = value
    
    message = TextSendMessage(text='\n'.join([k + ' ' + v for k, v in stock.items()]))
    line_bot_api.push_message(userid, message)

# 監聽所有來自 /callback 的 Post Request
@app.route("/callback", methods=['POST'])
def callback():
    # get X-Line-Signature header value
    signature = request.headers['X-Line-Signature']

    # get request body as text
    body = request.get_data(as_text=True)
    app.logger.info("Request body: " + body)

    # handle webhook body
    try:
        handler.handle(body, signature)
    except InvalidSignatureError:
        abort(400)
    return 'OK'
  
#訊息傳遞區塊
@handler.add(MessageEvent, message=TextMessage)
def handle_text_message(event):
    # 取得個人資料
    profile = line_bot_api.get_profile(event.source.user_id)
    nameid = profile.display_name
    uid = profile.user_id
    text = event.message.text

    print('uid: {}'.format(uid))
    print('name:{}'.format(nameid))
    print('keyword:{}'.format(text))

    # 買東西
    if text == '試試' or text.lower() == 'help':

        ###### 選單介面
        message = TemplateSendMessage(
                    alt_text='貓喵寶寶',
                    template=ButtonsTemplate(
                        thumbnail_image_url='https://image.cache.storm.mg/styles/smg-800xauto-er/s3/media/image/2020/06/23/20200623-072521_U7111_M620467_21f2.jpg?itok=KocIzJI0',
                        title='選單',
                        text='  ',
                        actions=[
                            MessageTemplateAction(
                                label='最新新聞',
                                text='news'
                            ),
                            MessageTemplateAction(
                                label='雙北天氣',
                                text='雙北天氣'
                            ),
                            MessageTemplateAction(
                                label='離島天氣',
                                text='離島天氣'
                            ),
                            MessageTemplateAction(
                                label='銷售排行',
                                text='top30'
                            )
                        ]
                    )
                )

    elif text == '新聞' or text.lower() == 'news':
        executor.submit(get_news,uid)

        message = StickerSendMessage(
                package_id=11539,
                sticker_id=52114133
            )

    # 傳送貼圖
    elif text == '貼圖':
        package_id = random.randint(1, 2)
        sticker_id = 1
        if package_id == '1':
            sticker_id = random.randint(1, 88)
            if sticker_id > 17:
                sticker_id = sticker_id + 83
            if sticker_id > 139:
                sticker_id = sticker_id + 262
        else:
            sticker_id = random.randint(18, 114)
            if sticker_id < 17:
                sticker_id = sticker_id + 17
            if sticker_id > 47:
                sticker_id = sticker_id + 93
            if sticker_id > 179:
                sticker_id = sticker_id + 313

        print('package_id: '+str(package_id))
        print('sticker_id:'+str(sticker_id))
        message = StickerSendMessage(
            package_id=package_id,
            sticker_id=sticker_id
        )

    elif text[0] == u'找':

        executor.submit(get_momo_search,text[1:],uid)

        message = StickerSendMessage(
                package_id=11537,
                sticker_id=52002770
            )
        
    elif text.lower() == 'list' and uid == 'Ube6a1a56c1466ec56cee2ae59ca0b17b':
        
        list = []
        with open("/app/member.json", "a") as f:
            list.append(f.read())
            
        message = TextSendMessage(text=''.join(list))
          
    elif text.lower() == 'top30':
        category = category_set[random.randint(0, len(category_set)-1)]
        if len(text.split(' ')) > 1:
            category = text.split(' ')[1];
        #end if
        executor.submit(get_momo_top30,category,uid)

        message = StickerSendMessage(
                package_id=11537,
                sticker_id=52002748
            )

    elif u'天氣' in text:
        executor.submit(get_current_weather,text,uid)

        message = StickerSendMessage(
                package_id=11539,
                sticker_id=52114113
            )     

    elif u'美女' in text or u'酒店' in text or u'辣妹' in text:
        
        global girl_img_urls
        if len(girl_img_urls) == 0:
            girl_img_urls = load_image_url()
        
        img_url = girl_img_urls[random.randint(0, len(girl_img_urls)-1)]
        print('img_url :{}'.format(img_url))
         
        message = ImageSendMessage(
            original_content_url=img_url,
            preview_image_url=img_url
        )
        
    else:
        ### 圖片
        message = StickerSendMessage(
            package_id=6632,
            sticker_id=11825376
        )
    #end if
        
    line_bot_api.reply_message(event.reply_token,message)

@handler.add(MessageEvent, message=StickerMessage)
def handle_sticker_message(event):
    line_bot_api.reply_message(
        event.reply_token,
        StickerSendMessage(
            package_id=1,
            sticker_id=406)
    )

@handler.add(MessageEvent, message=LocationMessage)
def handle_location_message(event):
    line_bot_api.reply_message(
        event.reply_token,
        LocationSendMessage(
            title=event.message.title, address=event.message.address,
            latitude=event.message.latitude, longitude=event.message.longitude
        )
    )

# Other Message Type
@handler.add(MessageEvent, message=(ImageMessage, VideoMessage, AudioMessage))
def handle_content_message(event):
    
    profile = line_bot_api.get_profile(event.source.user_id)
    ext = ''
    
    if isinstance(event.message, ImageMessage):
        ext = 'jpg'
    elif isinstance(event.message, VideoMessage):
        ext = 'mp4'
    elif isinstance(event.message, AudioMessage):
        ext = 'm4a'
    else:
        return
    
    message = TextSendMessage(
        text=('こんにちは ['+profile.display_name+'] はじめまして.'),
        sender=Sender(
        name="message",
            icon_url="https://thumbs2.imgbox.com/da/8b/5CFElnX5_t.png"
        )
    )
    
    line_bot_api.reply_message(event.reply_token,message)
    

@handler.add(MessageEvent, message=FileMessage)
def handle_file_message(event):
    xx = None

@handler.add(FollowEvent)
def handle_follow(event):

    profile = line_bot_api.get_profile(event.source.user_id)
    
    with open("/app/member.json", "a") as f:
        f.write('{} app[web.1]: follow:\n'.format(datetime.strptime(datetime.datetime.now(), "%d-%b-%Y-%H:%M:%S")))
        f.write('\t\tprofile: {}\n\n'.format(json.dumps(profile, indent=2)))    

    line_bot_api.reply_message(
        event.reply_token, TextSendMessage(text='welecome {} follow me.').format(profile.display_name))


@handler.add(UnfollowEvent)
def handle_unfollow(event):
    app.logger.info("Got Unfollow")

@handler.add(JoinEvent)
def handle_join(event):

    profile = line_bot_api.get_profile(event.source.user_id)
    
    with open("/app/member.json", "a") as f:
        f.write('{} app[web.1]: join:\n'.format(datetime.strptime(datetime.datetime.now(), "%d-%b-%Y-%H:%M:%S")))
        f.write('\t\tprofile: {}\n\n'.format(json.dumps(profile, indent=2)))
    
    line_bot_api.reply_message(
        event.reply_token, TextSendMessage(text='welecome {},Joined this {}.').format(profile.display_name, event.source.type))
    
@handler.add(LeaveEvent)
def handle_leave(event):
    app.logger.info("Got leave")


if __name__ == '__main__':

    app.run(debug=True)

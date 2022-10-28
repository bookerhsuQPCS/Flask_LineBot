# -*- coding: utf-8 -*-
"""
Line ChatBot
Created on Sat Nov 18 21:00:17 21

@author: bookerhsu
"""

import requests, re, random
import requests.packages.urllib3
from bs4 import BeautifulSoup

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

_headers = {
       'accept-encoding': 'gzip, deflate, br', 
       'accept-language': 'zh-TW,zh;q=0.9,en-US;q=0.8,en;q=0.7', 
       'Cache-Control': 'no-cache',
       'pragma': 'no-cache',
       'Upgrade-Insecure-Requests': '1',
       'user-agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36',
       'content-type': 'application/x-www-form-urlencoded',
       'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9'
    }


def get_keyword_search(keyword,uid):
    print('keyword:'+keyword)           
    target_url = 'https://m.momoshop.com.tw/search.momo?searchKeyword={}&couponSeq=&searchType=1&cateLevel=-1&ent=k&_imgSH=fourCardStyle'.format(keyword)
    print(target_url)
    
    # handle request body
    try:
        requests.packages.urllib3.disable_warnings()
        resp = requests.get(url=target_url, headers=_headers, timeout=15)
    except requests.exceptions.Timeout as tim:
        # Maybe set up for a retry, or continue in a retry loop
        print(tim)
        return None
    except requests.exceptions.TooManyRedirects as man:
        # Tell the user their URL was bad and try a different one
        print(man)
        return None
    except requests.exceptions.RequestException as e:
        # catastrophic error. bail.
        print(e)
        return None
    except requests.exceptions.HTTPError as err:
        print(err)
        return None
 
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
    
            _carouse_columns.append({
                    'thumbnail_image_url':img_url,
                    'text':_title,
                    'actions':[
                            {
                            'label':'去逛逛',
                            'uri':('https://m.momoshop.com.tw'+_a['href']) if 'http' not in _a['href'] else _a['href']
                            }
                        ]
                    })
        #end for
    
        message = {
            'alt_text':'',
            'carouse_columns':_carouse_columns
        }
    
    #end if
    
    print('get_keyword_search:end')
    
    return dict({'uid': uid, 'type':'template', 'content':message})

def get_momo_top30(uid):
    category = category_set[random.randint(0, len(category_set)-1)]
    print('category:'+category)
    
    target_url = 'https://m.momoshop.com.tw/category.momo?cn={}&top30New=y'.format(category)
    
    # handle request body
    try:
        requests.packages.urllib3.disable_warnings()
        resp = requests.get(url=target_url, headers=_headers, timeout=15)
    except requests.exceptions.Timeout as tim:
        # Maybe set up for a retry, or continue in a retry loop
        print(tim)
        return None
    except requests.exceptions.TooManyRedirects as man:
        # Tell the user their URL was bad and try a different one
        print(man)
        return None
    except requests.exceptions.RequestException as e:
        # catastrophic error. bail.
        print(e)
        return None
    except requests.exceptions.HTTPError as err:
        print(err)
        return None
 
    soup = BeautifulSoup(resp.text,"lxml")
    _cn = category
    _carouse_columns = []
    pathArea = soup.find("article", class_="pathArea")
    if pathArea is not None and len(pathArea) > 0:
        _cn = pathArea.find("a", attrs={"cn": category}).text
    #end if

    print('12345678')

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
                
                _carouse_columns.append({
                    'thumbnail_image_url':img_url,
                    'text':_alt,
                    'actions':[
                            {
                            'label':'去看看',
                            'uri':pd['href'] if 'http' in pd['href'] else 'https://m.momoshop.com.tw{}'.format(pd['href'])
                            }
                        ]
                })
            #end if
        # end loop
       
        msg = {
             'alt_text':'{} TOP30'.format(_cn),
             'carouse_columns':_carouse_columns
        }
    #end if
    
    print('get_momo_top30: end')
    
    return dict({'uid': uid, 'type':'template', 'content':msg})


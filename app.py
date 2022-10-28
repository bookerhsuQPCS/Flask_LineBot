# -*- coding: utf-8 -*-
"""
Line ChatBot
Created on Sat Nov 18 21:00:17 21

@author: bookerhsu
"""

import requests, configparser, random, os, datetime, json
import requests.packages.urllib3
from flask import Flask, request, abort
from concurrent.futures import ThreadPoolExecutor
from bs4 import BeautifulSoup

from linebot import (
    LineBotApi, WebhookHandler
)

from linebot.exceptions import (
    InvalidSignatureError
)

from linebot.models import (
    MessageEvent, TextMessage, TextSendMessage, ImageSendMessage, ImagemapSendMessage,
    SourceUser, SourceGroup, SourceRoom, Sender,
    TemplateSendMessage, ConfirmTemplate, MessageAction,
    ButtonsTemplate, ImageCarouselTemplate, ImageCarouselColumn, URIAction,
    PostbackAction, DatetimePickerAction,
    URITemplateAction, MessageTemplateAction, PostbackTemplateAction,
    CameraAction, CameraRollAction, LocationAction, MessageImagemapAction,
    URIImagemapAction, ImagemapArea, BaseSize, Video, ExternalLink,
    CarouselTemplate, CarouselColumn, PostbackEvent,
    StickerMessage, StickerSendMessage, LocationMessage, LocationSendMessage,
    ImageMessage, VideoMessage, AudioMessage, FileMessage,
    UnfollowEvent, FollowEvent, JoinEvent, LeaveEvent, BeaconEvent,
    FlexSendMessage, BubbleContainer, ImageComponent, BoxComponent,
    TextComponent, IconComponent, ButtonComponent,
    SeparatorComponent, QuickReply, QuickReplyButton
)

import maps, movie, book, beauty, momoShopping, cnaNews, cwbWeather, jpStreetGirls

## beginning..

app = Flask(__name__)

# 必須放上自己的Channel Access Token
line_bot_api = LineBotApi(os.environ['CHANNEL_ACCESS_TOKEN'])

# 必須放上自己的Channel Secret
handler = WebhookHandler(os.environ['CHANNEL_SECRET'])

# 必須放上自己的Channel Secret
adm_uid = WebhookHandler(os.environ['ADMIN_UISER_ID'])

# 讀取 config.ini
config = configparser.ConfigParser()
config.read("configure.ini")
# line_bot_api = LineBotApi(config['line_bot']['Channel_Access_Token'])
# handler = WebhookHandler(config['line_bot']['Channel_Secret'])

is_buy = False

girl_img_urls = []
category_set = []

executor = ThreadPoolExecutor(10)

# requests.packages.urllib3.disable_warnings()

def wait_to_push_message(future):
    
    try:
        result = future.result()
        print(result)
        
        if result is None:
            return
        
        if isinstance(result, dict):
            line_message = assemble(result)
            line_bot_api.push_message(result['uid'], line_message)
    
    except Exception as e:
        print(e)


def assemble(messaget):

    if messaget['type'] == 'text':
        return TextSendMessage(text=messaget['content'])

    elif messaget['type'] == 'template':
        _carouse_columns = []

        if isinstance(messaget['content']['carouse_columns'],list):
            for _carouse in messaget['content']['carouse_columns']:
                _carouse_columns.append(CarouselColumn(
                        thumbnail_image_url=_carouse['thumbnail_image_url'],
                        text=_carouse['text'],
                        actions=_carouse['actions']
                    )
                )
        
            return TemplateSendMessage(
                alt_text=messaget['content']['alt_text'],
                template=CarouselTemplate(
                    columns=_carouse_columns
                )
            )

    else: 
        raise Exception("Data provided can't be in the past")


def apple_news():
    target_url = 'http://www.appledaily.com.tw/realtimenews/section/new/'
    rs = requests.session()
    res = rs.get(target_url, verify=False)
    soup = BeautifulSoup(res.text, 'html.parser')
    content = ""
    for index, data in enumerate(soup.select('.rtddt a'), 0):
        if index == 3:
            return content

        link = data['href']
        notnews = link.find('entertainment')
        if notnews == -1:
            content += '{}\n\n'.format(link)
    return content

def ptt_hot():
    target_url = 'http://disp.cc/b/PttHot'
    rs = requests.session()
    res = rs.get(target_url, verify=False)
    soup = BeautifulSoup(res.text, 'html.parser')
    content = ""
    for index, data in enumerate(soup.select('#list div.row2 div span.listTitle')):
        if index <= 13:
            continue
        title = data.text
        link = "http://disp.cc/b/" + data.find('a')['href']
        if data.find('a')['href'] == "796-59l9": #[公告]
            break
        content += '{}\n{}\n\n'.format(title, link)
    return content

def currencylayer():
    target_url = 'http://apilayer.net/api/live?access_key='+config['currencylayer']['access_key']+'&currencies=TWD,JPY,CNY'
    response = requests.get(target_url)
    data = response.text
    parsed = json.loads(data)
    rates = parsed['quotes']
    content = ""
    for currency, rate in rates.items():
        content += currency+"="+str(rate)+"\n"
    return content[:-1]

def currency():
    target_url = 'http://rate.bot.com.tw/Pages/Static/UIP003.zh-TW.htm'
    rs = requests.session()
    res = rs.get(target_url, verify=False)
    res.encoding = 'utf-8'
    soup = BeautifulSoup(res.text, 'html.parser')
    content = ""
    for index, data in enumerate(soup.select('.rate-content-sight.text-right.print_hide')):
        if index == 1: 
            content += '美金(USD)'+data.text+"\n"
            print('美金(USD)' , data.text)
        elif index == 15:
            content += '日圓(JPY)'+data.text+"\n"
            print('日圓(JPY)' , data.text)
        elif index == 37:
            content += '人民幣(CNY)'+data.text
            print('人民幣(CNY)' , data.text)

    return content

def pm25():
    target_url = 'http://opendata2.epa.gov.tw/AQX.json'
    response = requests.get(target_url)
    data = response.text
    results = json.loads(data)
    content = results[3]['SiteName'] + ' PM2.5: '+ results[3]['PM2.5'] + ',狀態: ' + results[3]['Status']
    return content

def send_profile_to(profi):
    _message = None
    try:
        content = ('uid:['+profi.user_id+']\n' \
        +'name:['+profi.display_name+']\n' \
        +'AccessTime:['+datetime.datetime.now().strftime("%Y-%m-%dT%H:%M:%S")+']')
        _message = 'from line bot\n{}'.format(content)
    except TypeError as er:
        print(er)
        return None
    
    return _message


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
        print('InvalidSignatureError')
        abort(400)

    return 'OK'
  
#訊息傳遞區塊
@handler.add(MessageEvent, message=TextMessage)
def handle_text_message(event):
    # 取得個人資料
    profile = line_bot_api.get_profile(event.source.user_id)
    display_name = profile.display_name
    uid = profile.user_id
    text = event.message.text
    text_message = None
    rich_message = None

    print('uid: {}'.format(uid))
    print('name:{}'.format(display_name))
    print('keyword:{}'.format(text))
    
    send_profile_to(profile)

    # 傳送貼圖
    if text == '貼圖':
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
        rich_message = StickerSendMessage(
            package_id=package_id,
            sticker_id=sticker_id
        )

    elif text == "蘋果即時新聞":
        text_message = apple_news()
    elif text == "近期熱門廢文":  
        text_message = ptt_hot()  
    elif text == "近期上映":  
        text_message = movie.atmovies()
    elif text == "新片":  
        text_message = movie.truemovie() 
    elif text == "今日即期匯率":  
        text_message = currency()
    elif text == "吃什麼":  
        text_message = maps.randombysearch()
    elif( len(text) == 4 and text.isdigit() ):
        text_message = 'https://goodinfo.tw/StockInfo/StockDividendSchedule.asp?STOCK_ID='+ event.message.text
    elif( len(text) == 2 and text.isdigit() ):
        text_message = ''
    elif text == "USD":  
        text_message = currencylayer()
    elif text == "空氣":  
        text_message = pm25()
    elif text == "書": 
        text_message = book.books() + book.kobo() + book.taaze()    
    elif text == "正妹": 
        text_message = beauty.ptt_beauty()      
    # elif text == "larp": 
    #     text_msg = larp() 

    elif u'美女' in text or u'酒店' in text or u'辣妹' in text:
       
       global girl_img_urls
       if len(girl_img_urls) == 0:
           girl_img_urls = jpStreetGirls.load_image_url()
       
       img_url = girl_img_urls[random.randint(0, len(girl_img_urls)-1)]
        
       rich_message = ImageSendMessage(
           original_content_url=img_url,
           preview_image_url=img_url
       )
       
    elif u'肥' in text:
       
       rich_message = ImagemapSendMessage(
           base_url='https://i.imgur.com/wpM584d.jpg',
           alt_text='this is an imagemap',
           base_size=BaseSize(height=1040, width=1040),
           video=Video(
                   original_content_url='https://i.imgur.com/1BnZGQC.mp4',
                   preview_image_url='https://imgur.com/SVhJU6w.jpg',
                   area=ImagemapArea(
                   x=0, y=0, width=1040, height=585
               ),
               external_link=ExternalLink(# 影片結束後的連結
                   link_uri='https://marketingliveincode.com/',
                   label='查看更多…',
               ),
           ),
           actions=[
               URIImagemapAction(# 超連結
                   link_uri='https://marketingliveincode.com/',
                   area=ImagemapArea(
                       x=0, y=0, width=520, height=1040
                   )
               ),
               MessageImagemapAction(# 文字訊息
                   text='肥戳我幹嘛！',
                   area=ImagemapArea(
                       x=520, y=0, width=520, height=1040
                   )
               )
           ]
       )

    # 買東西
    elif text == '試試' or text.lower() == 'help':

        ###### 選單介面
        rich_message = TemplateSendMessage(
                    alt_text='貓喵寶寶',
                    template=ButtonsTemplate(
                        thumbnail_image_url='https://image.cache.storm.mg/styles/smg-800xauto-er/s3/media/image/2020/06/23/20200623-072521_U7111_M620467_21f2.jpg?itok=KocIzJI0',
                        title='選單',
                        text='熱騰騰',
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
                            ),
							MessageTemplateAction(
                                label='PTT 熱門廢文',
                                text='近期熱門廢文'
                            ),
							MessageTemplateAction(
                                label='近期上映',
                                text='近期上映'
                            ),
							MessageTemplateAction(
                                label='新片評比',
                                text='新片'
                            ),
							MessageTemplateAction(
                                label='即期匯率',
                                text='今日即期匯率'
                            ),
							MessageTemplateAction(
                                label='想吃什麼',
                                text='吃什麼'
                            ),
							MessageTemplateAction(
                                label='美元匯率',
                                text='USD'
                            ),
							MessageTemplateAction(
                                label='空氣品質',
                                text='空氣'
                            ),
							MessageTemplateAction(
                                label='暢銷書',
                                text='書'
                            ),
							MessageTemplateAction(
                                label='當紅正妹',
                                text='正妹'
                            )
                        ]
                    )
                )

    elif text == '新聞' or text.lower() == 'news':
        
        future= executor.submit(cnaNews.get_taiwan_news,text,uid)
        future.add_done_callback(wait_to_push_message)

        rich_message = StickerSendMessage(
                package_id=11539,
                sticker_id=52114133
            )

    elif u'天氣' in text:
        
        future = executor.submit(cwbWeather.get_taiwan_weather,text,uid)
        future.add_done_callback(wait_to_push_message)

        rich_message = StickerSendMessage(
                package_id=11539,
                sticker_id=52114113
            )

    elif text[0] == u'找':

        future = executor.submit(momoShopping.get_keyword_search,text[1:],uid)
        future.add_done_callback(wait_to_push_message)

        rich_message = StickerSendMessage(
                package_id=11537,
                sticker_id=52002770
            )
          
    elif text.lower() == 'top30':
        category = category_set[random.randint(0, len(category_set)-1)]
        if len(text.split(' ')) > 1:
            category = text.split(' ')[1];
        #end if
        
        futur = executor.submit(momoShopping.get_momo_top30,category,uid)
        future.add_done_callback(wait_to_push_message)

        rich_message = StickerSendMessage(
                package_id=11537,
                sticker_id=52002748
            )
        
    else:
        ### 圖片
        rich_message = StickerSendMessage(
            package_id=6632,
            sticker_id=11825376
        )
    #end if
        
    if text_message is not None and len(text_message) > 0:
        line_bot_api.reply_message(event.reply_token,TextSendMessage(text=text_message))
        text_message = None
    else:
        line_bot_api.reply_message(event.reply_token,rich_message)
        rich_message = None

    ## need background thread.
    # for res in as_completed(futures):
    #     print(res.result())
    #     result = res.result()
    #     line_message = assemble(result)
    #     if isinstance(line_message, TextSendMessage):
    #         print(type(line_message))
    #         line_bot_api.push_message(adm_uid, line_message)
        

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
    beauty.send_profile_to(profile)
    ext = ''
    
    if isinstance(event.message, ImageMessage):
        ext = 'jpg'
    elif isinstance(event.message, VideoMessage):
        ext = 'mp4'
    elif isinstance(event.message, AudioMessage):
        ext = 'm4a'
    else:
        return
    
    text_message = TextSendMessage(
        text=('こんにちは ['+profile.display_name+'] はじめまして.'),
        sender=Sender(
        name="message",
            icon_url="https://thumbs2.imgbox.com/da/8b/5CFElnX5_t.png"
        )
    )
    
    line_bot_api.reply_message(event.reply_token,text_message)

@handler.add(MessageEvent, message=FileMessage)
def handle_file_message(event):
    xy = None

@handler.add(FollowEvent)
def handle_follow(event):

    profile = line_bot_api.get_profile(event.source.user_id)
    content = ('uid:['+profile.user_id+']\n' \
    +'name:['+profile.display_name+']\n' \
    +'FollowTime:['+datetime.datetime.now().strftime("%Y-%m-%dT%H:%M:%S")+']')
    
    line_bot_api.push_message(adm_uid, TextSendMessage(text='from line bot\n{}'.format(content)))

    line_bot_api.reply_message(
        event.reply_token, TextSendMessage(text='welecome {} follow me.').format(profile.display_name))

@handler.add(UnfollowEvent)
def handle_unfollow(event):
    app.logger.info("Got Unfollow")

@handler.add(JoinEvent)
def handle_join(event):

    profile = line_bot_api.get_profile(event.source.user_id)
    content = ('uid:['+profile.user_id+']\n' \
    +'name:['+profile.display_name+']\n' \
    +'JoinTime:['+datetime.datetime.now().strftime("%Y-%m-%dT%H:%M:%S")+']')
    
    line_bot_api.push_message(adm_uid, TextSendMessage(text='from line bot\n{}'.format(content)))
    
    line_bot_api.reply_message(
        event.reply_token, TextSendMessage(text='welecome {},Joined this {}.').format(profile.display_name, event.source.type))
    
@handler.add(LeaveEvent)
def handle_leave(event):
    app.logger.info("Got leave")


if __name__ == '__main__':

    app.run(debug=True)

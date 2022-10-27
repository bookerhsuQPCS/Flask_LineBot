# -*- coding: utf-8 -*-
"""
Created on Wed Oct 26 21:35:35 2022

@author: 徐子陵
"""
# -*- coding: utf-8 -*-
"""
Line ChatBot
Created on Sat Nov 18 21:00:17 21

@author: bookerhsu
"""
import datetime

def load_image_url():
    _img_urls = []

    with open("/app/girl_img_urls.lst", "r") as f:
        for row in f:
            _img_urls.append(row.rstrip('\n'))
    
    return _img_urls

def send_profile_to(prof):
    
    message = None
    
    try:
        sts1 = ('uid:['+prof.user_id+']\n' \
        +'name:['+prof.display_name+']\n' \
        +'AccessTime:['+datetime.datetime.now().strftime("%Y-%m-%dT%H:%M:%S")+']')

        message = 'from line bot\n{}'.format(sts1)
        
    except TypeError as er:
        print(er)
        return None
        
    return message

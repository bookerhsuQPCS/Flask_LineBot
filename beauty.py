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


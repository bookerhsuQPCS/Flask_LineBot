# -*- coding: utf-8 -*-
"""

中時電子報.

Created on Wed Oct 26 21:04:43 2022

@author: 徐子陵
"""
import feedparser

def get_taiwan_news(uid):
    """
    建立十個抓最新新聞消息
    """

    message = None
    rss_url = 'http://feeds.feedburner.com/cnaFirstNews'
    # 抓取資料
    news = []
    rss = feedparser.parse(rss_url)
    for i, entry in enumerate(rss.entries[:10], start=0):
        news.append(entry['title'] + ' ' + entry['link'])
    #end if
    
    if len(news) > 0:
        message = "\n".join(news)
    #end if
    
    return {'uid': uid, 'type':'text', 'content':message}
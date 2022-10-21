package com.sp.platform.shareCache;

import org.springframework.stereotype.Component;
import net.minidev.json.JSONArray;
import com.sp.commons.util.JsonUtil;
import com.sp.db.redis.JedisUtil;

@Component
public class NewsCache {
    public static final int newsRedisDB = 0;
    public static final String newsRedisKey = "NEWS";
    
    public boolean addNews(String news){
        return JedisUtil.putRedisCache(newsRedisDB, newsRedisKey, news);
    }
    
    public JSONArray getNews(){
        String jsonStr = (String) JedisUtil.getRedisObject(newsRedisDB, newsRedisKey);
        return JsonUtil.convertJsonArray(jsonStr);
    }
}

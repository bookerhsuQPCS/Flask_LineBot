package com.sp.platform.shareCache;

import org.springframework.stereotype.Component;
import com.sp.db.redis.JedisUtil;
import com.sp.platform.shareEnum.RedisDB;

@Component
public class ValidateCodeCache {
    private final int redisDb = RedisDB.VALIDATE_CODE.getValue();
    private static final int redisExpireTime = 60;


    // 查詢
    public String getValidateCode(String uuid) {
        Object redisObj = JedisUtil.getRedisObject(redisDb, uuid);
        StringBuilder vCode = new StringBuilder();
        if (redisObj != null) {
            vCode.append(redisObj.toString());
        }
        return vCode.toString();
    }

    // 新增
    public boolean putValidateCode(String uuid, String validateCode) {
        return JedisUtil.putRedisCache(redisDb, uuid, validateCode, redisExpireTime);
    }

    // 刪除
    public boolean removeValidateCode(String uuid) {
        return JedisUtil.removeRedisObject(redisDb, uuid);
    }


}

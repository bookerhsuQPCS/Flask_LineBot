package com.sp.platform.shareCache;

import com.sp.commons.util.JsonUtil;
import com.sp.commons.util.LogUtil;
import com.sp.db.redis.JedisUtil;
import com.sp.platform.commission.dto.Commission;
import com.sp.platform.commission.service.CommissionService;
import com.sp.platform.shareEnum.RedisDB;
import com.sp.platform.shareException.PlatformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommCache {
    @Autowired
    private CommissionService commissionService;

    private static final int redisExpireTime = 60 * 5; // 5分鐘

    public Commission getComm(String userId, String thirdPartyType) {
        Commission comm = null;
        String key = getKey(userId, thirdPartyType);
        Object jsonStr = JedisUtil.getRedisObject(RedisDB.COMM.getValue(), key);
        if(jsonStr != null){
            comm = JsonUtil.readValue(jsonStr.toString(), Commission.class);
        } else {
            List<Commission> list = new ArrayList<Commission>();
            try {
                list = commissionService.getCommissionByUser(userId);
            } catch(PlatformException e){
                LogUtil.getWebInfoLogger().error("getCommissionByUser error, userId:"+userId, e);
            }
            for (Commission commission : list) {
                setComm(commission);
                if (thirdPartyType.equals(commission.getThirdPartyType())) {
                    comm = commission;
                }
            }
        }
        return comm;
    }

    public boolean setComm(Commission comm){
        String key = getKey(comm.getUserId(), comm.getThirdPartyType());
        return JedisUtil.putRedisCache(RedisDB.COMM.getValue(), key, JsonUtil.toJSon(comm), redisExpireTime);
    }

    public String getKey(String userId, String thirdPartyType){
        return "comm_" + userId + "_" + thirdPartyType;
    }
}

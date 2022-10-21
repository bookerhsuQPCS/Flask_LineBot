package com.sp.platform.shareCache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sp.commons.util.LogUtil;
import com.sp.platform.apiGameSwitch.dto.ApiGameSwitch;
import com.sp.platform.apiGameSwitch.service.ApiGameSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ApiGameSwitchCache extends RootCache {

    private LoadingCache<String, ApiGameSwitch> apiGameSwitchCache;

    private final long duration = 1;

    @Autowired
    private ApiGameSwitchService apiGameSwitchService;

    private ApiGameSwitchCache() {
        apiGameSwitchCache = CacheBuilder.newBuilder()
                .expireAfterWrite(duration, TimeUnit.MINUTES)
                .build(new CacheLoader<String, ApiGameSwitch>() {
                    //默認的數據加載實現,當調用get取值的時候,如果key沒有對應的值,就調用這個方法進行加載.
                    @Override
                    public ApiGameSwitch load(String key) {//reload DB
                        return apiGameSwitchService.syncActivationApiGameSwitchToCache(key);
                    }
                });
    }

//    /**
//     * 遊戲開關狀態緩存是否為空
//     *
//     * @return
//     */
//    public boolean isEmptyForApiGameSwitch() {
//        return apiGameSwitchCache.size() == 0;
//    }

    /**
     * 以key取得遊戲開關狀態
     *
     * @param key
     * @return
     */
    public ApiGameSwitch getValueByApiGameSwitch(String key) {
        ApiGameSwitch result = null;
        try {
            result = getLocalObject(apiGameSwitchCache, key);
        } catch (Exception e) {
            LogUtil.getWebInfoLogger().info(e + ", getValueByApiGameSwitch key:" + key);
        }
        return result;
    }


    /**
     * 放入遊戲開關狀態到緩存
     *
     * @param apiGameSwitch
     */
    public void setApiGameSwitchLocalCache(ApiGameSwitch apiGameSwitch) {
        setLocalObject(apiGameSwitchCache, apiGameSwitch.getKey(), apiGameSwitch);
    }


    /**
     * 移除所有遊戲開關狀態緩存
     */
    public void removeAllApiGameSwitchs() {
        apiGameSwitchCache.invalidateAll();
    }

    /**
     *
     * @param comId
     * @param thirdPartyType
     * @return
     */
    public String getKey(String comId, String thirdPartyType) {
        StringBuffer sb = new StringBuffer();
        sb.append(comId);
        sb.append("@");
        sb.append(thirdPartyType);
        return sb.toString();
    }

}

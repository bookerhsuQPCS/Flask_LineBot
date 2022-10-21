package com.sp.platform.shareCache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sp.commons.util.LogUtil;
import com.sp.platform.cash.backend.dto.Role;
import com.sp.platform.cash.backend.dto.RoleFuncData;
import com.sp.platform.cash.backend.service.RoleFuncDataService;
import com.sp.commons.dto.Accounts;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleFuncDataCache extends RootCache {
    private LoadingCache<String, List<RoleFuncData>> cache;

    private final long duration = 2;

    @Autowired
    private RoleFuncDataService roleFuncDataService;
    @Autowired
    private AccountCache accountCache;

    private RoleFuncDataCache() {
        cache = CacheBuilder.newBuilder()
            .expireAfterWrite(duration, TimeUnit.MINUTES)
            .build(new CacheLoader<String, List<RoleFuncData>>() {
                //默認的數據加載實現,當調用get取值的時候,如果key沒有對應的值,就調用這個方法進行加載.
                @Override
                public List<RoleFuncData> load(String key) {//reload DB
                    Accounts user = accountCache.getUser(key);
                    if(user == null){
                        //TODO: 從DB撈
                    }
                    List<RoleFuncData> list = new ArrayList<RoleFuncData>();
                    try{
                        list = roleFuncDataService.getFuncDataByRole(user.getComId(), user.getRoleId());
                    }catch(Exception e){
                        LogUtil.getWebInfoLogger().error(e.getMessage(), e);
                    }
                    return list;
                }
            });
    }

    /**
     * 以userId取得RoleFuncDataList
     * @param key
     * @return
     */
    public List<RoleFuncData> getValue(String key) {
        List<RoleFuncData> result = null;
        LogUtil.getWebInfoLogger().debug("getValue key:"+ key);
        try {
            result = getLocalObject(cache, key);
            LogUtil.getWebInfoLogger().debug("getValue result:"+ result);
        } catch (Exception e) {
            //when key is not exists
            LogUtil.getWebInfoLogger().error(e + ", getValue key:" + key);
        }
        return result;
    }
}

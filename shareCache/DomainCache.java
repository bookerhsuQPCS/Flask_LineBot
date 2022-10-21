package com.sp.platform.shareCache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sp.commons.util.LogUtil;
import com.sp.platform.domain.dto.Domain;
import com.sp.platform.domain.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DomainCache extends RootCache {

    private LoadingCache<String, String> domainNameCache;

    private final long duration = 2;

    @Autowired
    private DomainService domainService;

    private DomainCache() {
        domainNameCache = CacheBuilder.newBuilder()
                .expireAfterWrite(duration, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    //默認的數據加載實現,當調用get取值的時候,如果key沒有對應的值,就調用這個方法進行加載.
                    @Override
                    public String load(String key) {//reload DB
                        return domainService.syncActivationDomainNameToCache(key);
                    }
                });
    }

    /**
     * 域名緩存是否為空
     *
     * @return
     */
    public boolean isEmptyForDomainName() {
        return domainNameCache.size() == 0;
    }

    /**
     * 以域名取得COM_ID
     *
     * @param key
     * @return
     */
    public String getValueByDomainName(String key) {
        String result = null;
        try {
            result = getLocalObject(domainNameCache, key);
        } catch (Exception e) {
            //when key is not exists
            //com.google.common.cache.CacheLoader$InvalidCacheLoadException: CacheLoader returned null for key 103.100.153.102.
            LogUtil.getWebInfoLogger().info(e + ", getValueByDomainName key:" + key);
        }
        return result;
    }




    /**
     * 放入域名到緩存
     *
     * @param domain
     */
    public void setDomainNameLocalCache(Domain domain) {
        setLocalObject(domainNameCache, domain.getDomainName(), domain.getComId());
    }

    /**
     * 放入域名到緩存
     * @param domainName
     * @param comId
     */
    public void setDomainNameLocalCache(String domainName, String comId) {
        setLocalObject(domainNameCache, domainName, comId);
    }


    /**
     * 移除所有域名緩存
     */
    public void removeAllDomainNames() {
        domainNameCache.invalidateAll();
    }

}

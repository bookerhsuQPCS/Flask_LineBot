package com.sp.platform.shareCache;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.sp.commons.util.LogUtil;
import com.sp.platform.cash.backend.dto.PT;
import com.sp.platform.cash.backend.service.PTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class PTCache extends RootCache {

    private LoadingCache<String, Optional<PT>> ptCache;

    private final long cacheSize = 1000000;
    private final long duration = 30;

    @Autowired
    PTService ptService;


    public PTCache() {
        ptCache = CacheBuilder.newBuilder()
                .maximumSize(cacheSize)
                .refreshAfterWrite(duration, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Optional<PT>>() {
            @Override public Optional<PT> load(String key) throws Exception {

                return Optional.fromNullable(getLocalCache(key));
            }

            @Override public ListenableFuture<Optional<PT>> reload(String key, Optional<PT> oldValue) throws Exception {
                ptService.syncUserPTs(key);
                return Futures.immediateFuture(Optional.fromNullable(getLocalCache(key)));

            }
        });
    }

    public void setLocalCache(PT data) {
        String key = "";
        key = getKey(data.getUserId(), data.getSourceName());
        ptCache.put(key, Optional.of(data));
    }

    public PT getLocalCacheByUserIdAndGameSource(String userId, String gameSource) {
        String key = getKey(userId, gameSource);
        return getLocalCache(key);
    }

    public PT getLocalCache(String key) {
        PT pt = null;
        try {
            if (ptCache.size() == 0) {
                ptService.syncAllPTs();
            }
            Optional<PT> oppt = ptCache.get(key);
            if (oppt.isPresent()) {
                pt = oppt.get();
            }
        } catch (ExecutionException e) {
            LogUtil.getWebInfoLogger().error(e);
        } catch (IllegalStateException e) {
            LogUtil.getWebInfoLogger().error(e.getMessage());
        }
        return pt;
    }

    public String getKey(String userId, String gameSource){
        return "pt_" + userId + "_" + gameSource;
    }
}

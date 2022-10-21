package com.sp.platform.shareCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sp.commons.util.LogUtil;
import com.sp.platform.shareDTO.GameLimitSetting;
import com.sp.platform.shareService.GameLimitSettingService;

@Component
public class GameLimitSettingCache {


    @Autowired
    private GameLimitSettingService gameLimitSettingService;

    private LoadingCache<String, GameLimitSetting> gameLimitSettingCache;
    private final long cacheSize = 1000000;
    private final long ttl = 30;



    public GameLimitSettingCache() {
        gameLimitSettingCache = CacheBuilder.newBuilder().maximumSize(cacheSize).refreshAfterWrite(ttl, TimeUnit.MINUTES).build(new CacheLoader<String, GameLimitSetting>() {
            @Override
            public GameLimitSetting load(String key) throws Exception {

                gameLimitSettingService.syncAllGameLimitSettings();
                String[] keys = key.split("_");

                GameLimitSetting gameLimitSetting = getLocalCache(keys[0], keys[1], keys[2], keys[3]);
                return gameLimitSetting;
            }

        });
    }

    private GameLimitSetting getLocalCache(String sourceName, String level, String currency, String ruleId) {
        GameLimitSetting gameLimitSetting = null;
        try {
            if (gameLimitSettingCache.size() == 0) {
                gameLimitSettingService.syncAllGameLimitSettings();
            }
            gameLimitSetting = gameLimitSettingCache.get(getKey(sourceName, level, currency, ruleId));
        } catch (ExecutionException e) {
            LogUtil.getWebInfoLogger().error(e);
        }
        return gameLimitSetting;
    }

    // 取得指定sourceName跟currency的所有GameLimitSetting
    public List<GameLimitSetting> getSourceNameCurrencyList(String sourceName, String currency) {
        List<GameLimitSetting> gameLimitSettingList = new ArrayList<GameLimitSetting>();
        if (gameLimitSettingCache.size() == 0) {
            gameLimitSettingService.syncAllGameLimitSettings();
        }
        for (GameLimitSetting gameLimitSetting : gameLimitSettingCache.asMap().values()) {
            if (StringUtils.equals(gameLimitSetting.getSourceName(), sourceName) && StringUtils.equals(gameLimitSetting.getCurrency(), currency)) {
                gameLimitSettingList.add(gameLimitSetting);
            }
        }

        Collections.sort(gameLimitSettingList, new Comparator<GameLimitSetting>() {
            @Override
            public int compare(GameLimitSetting gameLimitSetting1, GameLimitSetting gameLimitSetting2) {
                String level1 = gameLimitSetting1.getLevel();
                String level2 = gameLimitSetting2.getLevel();
                return level1.compareTo(level2);
            }
        });

        return gameLimitSettingList;
    }

    // 取得指定sourceName、level、currency的所有GameLimitSetting
    public List<GameLimitSetting> getSourceNameLevelCurrencyList(String sourceName, String level, String currency) {
        List<GameLimitSetting> gameLimitSettingList = new ArrayList<GameLimitSetting>();
        if (gameLimitSettingCache.size() == 0) {
            gameLimitSettingService.syncAllGameLimitSettings();
        }
        for (GameLimitSetting gameLimitSetting : gameLimitSettingCache.asMap().values()) {
            if (StringUtils.equals(gameLimitSetting.getSourceName(), sourceName) && StringUtils.equals(gameLimitSetting.getLevel(), level)
                            && StringUtils.equals(gameLimitSetting.getCurrency(), currency)) {
                gameLimitSettingList.add(gameLimitSetting);
            }
        }

        return gameLimitSettingList;
    }



    public void setLocalCache(GameLimitSetting gameLimitSetting) {
        gameLimitSettingCache.put(getKey(gameLimitSetting.getSourceName(), gameLimitSetting.getLevel(), gameLimitSetting.getCurrency(), gameLimitSetting.getRuleId()), gameLimitSetting);
    }

    public String getKey(String sourceName, String level, String currency, String ruleId) {
        StringBuffer sb = new StringBuffer();
        sb.append(sourceName).append("_").append(level).append("_").append(currency).append("_").append(ruleId);
        return sb.toString();
    }


}

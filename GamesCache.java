package com.sp.thirdpartyapi.cache;

import com.google.common.base.Optional;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sp.commons.util.LogUtil;
import com.sp.commons.util.StringUtil;
import com.sp.thirdpartyapi.dto.Games;
import com.sp.thirdpartyapi.service.GamesService;

@Component
public class GamesCache extends RootCache {
    private LoadingCache<String, Optional<Games>> gamesCache;
    @Autowired
    private GamesService gamesService;

    public GamesCache() {
        gamesCache = CacheBuilder.newBuilder()
            .maximumSize(2000)
            .build(new CacheLoader<String, Optional<Games>>() {
                @Override
                public Optional<Games> load(String key) {
                    Games game = syncAllGames(key);
                    return Optional.fromNullable(game);
                }
        });
    }

    public void setLocalCache(Games game) {
        String key = getKey(game.getThirdPartyType(), game.getGameNo());
        gamesCache.put(key, Optional.fromNullable(game));
    }

    public Games getLocalCache(String key) {
        Games game = null;
        try {
            Optional<Games> opt = gamesCache.get(key);
            if(opt.isPresent()){
                game = opt.get();
            }else{
                game = syncAllGames(key);
            }
        } catch (ExecutionException e) {
            LogUtil.getWebInfoLogger().error(e.getMessage(), e);
        }
        return game;
    }

    public Games getLocalCache(String thirdPartyType, String gameNo) {
        String key = getKey(thirdPartyType, gameNo);
        return getLocalCache(key);
    }

    public String getKey(String thirdPartyType, String gameNo){
        StringBuilder sb = new StringBuilder();
        sb.append(thirdPartyType).append("_").append(gameNo);
        return sb.toString();
    }

    public Games syncAllGames(String key) {
        Games targetGame = null;
        List<Games> list = gamesService.getAllGames();
        for(Games game : list){
            setLocalCache(game);
            if(key.equals(game.getThirdPartyType()+"_"+game.getGameNo())){
                targetGame = game;
            }
        }
        return targetGame;
    }
}

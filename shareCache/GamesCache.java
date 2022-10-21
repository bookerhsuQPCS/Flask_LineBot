package com.sp.platform.shareCache;

import com.google.common.base.Optional;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sp.commons.util.LogUtil;
import com.sp.platform.cash.backend.dto.Games;
import com.sp.platform.cash.backend.service.GamesService;

@Component
public class GamesCache extends RootCache {
    private LoadingCache<String, Optional<Games>> gamesCache;
    @Autowired
    private GamesService gamesService;

//    public GamesCache() {
//        gamesCache = CacheBuilder.newBuilder().maximumSize(10000).build(new CacheLoader<String, Games>() {
//            @Override
//            public Games load(String key) throws Exception {
//
//                gamesService.syncAllGames();
//                String[] keys = key.split("_");
//
//                Games games = getLocalCache(keys[0], keys[1], Integer.parseInt(keys[2]), Integer.parseInt(keys[3]), keys[4]);
//                return games;
//            }
//        });
//    }
//
//    public Games getGamesBySourceGameCode(String sourceId, String gameCode) {
//        Games games = null;
//        if (gamesCache.size() == 0) {
//            gamesService.syncAllGames();
//        }
//        for (Games game : gamesCache.asMap().values()) {
//            if (game.getSourceName().contains(sourceId) && game.getGameNo().equals(gameCode)) {
//                games = game;
//                break;
//            }
//        }
//
//        return games;
//    }

//    private Games getLocalCache(String sourceName, String gameEn, Integer gameType, Integer gameSubType, String gameNo) {
//        Games game = null;
//        try {
//            if (gamesCache.size() == 0) {
//                gamesService.syncAllGames();
//            }
//            game = gamesCache.get(getKey(sourceName, gameEn, gameType, gameSubType, gameNo));
//        } catch (ExecutionException e) {
//            LogUtil.getWebInfoLogger().error(e);
//        }
//        return game;
//    }
//
//    public void setLocalCache(Games game) {
//        String key = getKey(game.getSourceName(), game.getGameNameEn(), game.getGameType(), game.getSubType(), game.getGameNo());
//        gamesCache.put(key, game);
//    }
//
//    public String getKey(String sourceName, String gameEn, Integer gameType, Integer gameSubType, String gameNo) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(StringUtil.isEmpty(sourceName) ? "_" : sourceName + "_");
//        sb.append(StringUtil.isEmpty(gameEn) ? "_" : gameEn + "_");
//        sb.append(gameType == null ? "_" : gameType + "_");
//        sb.append(gameSubType == null ? "_" : gameSubType + "_");
//        sb.append(StringUtil.isEmpty(gameNo) ? "" : gameNo + "");
//
//        return sb.toString();
//    }



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


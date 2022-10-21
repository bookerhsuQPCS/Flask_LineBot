package com.sp.platform.shareCache;

import com.sp.commons.util.CacheUtil;
import com.sp.commons.util.JsonUtil;
import com.sp.commons.util.LogUtil;
import com.sp.db.dao.DbUtils;
import com.sp.db.redis.JedisUtil;
import com.sp.db.util.DataSourceUtil;
import com.sp.platform.cash.backend.dao.AccountsDAO;
import com.sp.platform.cash.frontend.service.FCashGameService;
import com.sp.commons.dto.Accounts;
import com.sp.platform.shareEnum.CashLevel;
import com.sp.platform.shareEnum.DateTime;
import com.sp.platform.shareService.AccountService;
import com.sp.platform.shareService.TransferService;
import com.sp.platform.shareUtil.ExitGameManager;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class AccountCache {

    public static final int accountRedisDB = 1;

    private final static int redisExpireTime = DateTime.SESSION_TIME.getValue(); //2hr + 10 mins

    @Autowired
    private AccountsDAO accountsDAO;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransferService transferService;
    @Autowired
    private AccountCache accountCache;
    @Autowired
    private FCashGameService fCashGameService;


    public Accounts getUser(String uid) {
        Accounts user = null;
        Object jsonStr = JedisUtil.getRedisObject(accountRedisDB, uid);
        if (jsonStr != null) {
            user = JsonUtil.readValue(jsonStr.toString(), Accounts.class);

        }
        return user;
    }

    public boolean addUser(Accounts user) {
        return addUser(user.getUserId(), user);
    }

    public boolean addUser(String uid, Accounts user) {
        return JedisUtil.putRedisCache(accountRedisDB, uid, JsonUtil.toJSon(user), redisExpireTime);
    }

    public boolean removeUser(String uid) {
        return JedisUtil.removeRedisObject(accountRedisDB, uid);
    }

    public boolean removeUsers(Jedis jedis, List<String> uids) {
        return JedisUtil.pipelinedRemove(jedis, accountRedisDB, uids);
    }

    public Map<String, String> getUsers(List<String> uids) {
        return CacheUtil.getInstance().pipelineGet(accountRedisDB, uids, String.class);
    }
    public List<Accounts> getAllUsers(){
        List<Accounts> users = new ArrayList<>();
        List<Object> tmpList = CacheUtil.getInstance().getAllObject(accountRedisDB);
        tmpList.forEach(o->{
            users.add(JsonUtil.readValue(o.toString(), Accounts.class));
        });
        return users;
    }

    public boolean setUsers(Map<String, String> userList) {
        Map<String, Object> usersMap = new HashMap<String, Object>();
        for (String userId : userList.keySet()) {
            usersMap.put(userId, userList.get(userId));
        }
        return CacheUtil.getInstance().pipelineSetWithOriginTTL(accountRedisDB, usersMap);
    }

    public boolean putAccount(String userStr, Accounts user) {
        return JedisUtil.putRedisCache(accountRedisDB, userStr, JsonUtil.toJSon(user), redisExpireTime);
    }

    public void syncAccount() {
        Map<String, String> datas = new HashMap<String, String>();
        Jedis jedis = null;
        Long accountRedisSize = 0L;
        try {
            jedis = JedisUtil.getJedis(accountRedisDB);
            accountRedisSize = jedis.dbSize();
        } finally {
            JedisUtil.returnJedis2Pool(jedis);
        }

        if (accountRedisSize > 0) {
            try {
                List<Accounts> list = accountService.getLoginAccounts("Y");
                List<String> idList = list.parallelStream().map(Accounts::getUserId).collect(Collectors.toList());
                Map<String, String> tmpList = getUsers(idList);
                for (Accounts account : list) {
                    String accountJsonStr = tmpList.get(account.getUserId());
                    if (accountJsonStr != null) {
                        Accounts tmpUser = JsonUtil.readValue(accountJsonStr, Accounts.class);
//                        account.setSafeCode(tmpUser.getSafeCode());
                        account.setTtl(tmpUser.getTtl());
                        account.setDevice(tmpUser.getDevice());
                        // TTL剩2分鐘時踢掉玩家
                        if (tmpUser.getTtl() != null && tmpUser.getTtl() < 120) {
                            LogUtil.getWebInfoLogger().info("Account Sync TTL < 120 Logout! userId:" + account.getUserId());
                            if(account.getLevel() > CashLevel.MA.getKey() && account.getLevel() <= CashLevel.PL.getKey()) {
                                ExitGameManager.exitGame(account, "OUT", "", transferService, fCashGameService, accountCache, accountsDAO);// 登出所有遊戲並將餘額收回平台後登出平台
                            }
                            accountService.updateTime(account.getUserId(), "logOut");
                        } else {
                            datas.put(account.getUserId(), JsonUtil.toJSon(account));
                        }
                    } else {
                        LogUtil.getWebInfoLogger().info("Account Sync TmpUser is Null. Logout! userId:" + account.getUserId());
                        if(account.getLevel() > CashLevel.MA.getKey() && account.getLevel() <= CashLevel.PL.getKey()) {
                            ExitGameManager.exitGame(account, "OUT", "", transferService, fCashGameService, accountCache, accountsDAO);// 登出所有遊戲並將餘額收回平台後登出平台
                        }
                        accountService.updateTime(account.getUserId(), "logOut");
                    }
                }
                setUsers(datas);
            } catch (Exception e) {
                LogUtil.getWebInfoLogger().error(e.getMessage(), e);
            }
        }
    }

}

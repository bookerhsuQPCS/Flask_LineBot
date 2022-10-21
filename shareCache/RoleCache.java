package com.sp.platform.shareCache;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sp.commons.util.LogUtil;
import com.sp.db.dao.DbUtils;
import com.sp.db.util.DataSourceUtil;
import com.sp.platform.cash.backend.dao.RoleDAO;
import com.sp.platform.cash.backend.dto.Role;

@Component
public class RoleCache extends RootCache {
    private Cache<Integer, Role> roleCache;

    @Autowired
    private RoleDAO roleDAO;

    private RoleCache() {
        roleCache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.HOURS).build();
    }

    public void setRole(Integer roleId, Role role) {
        super.setLocalObject(roleCache, roleId, role);
    }

    public Role getRole(Integer roleId) {
        return super.getLocalObject(roleCache, roleId);
    }

    /**
     * 同步資料庫與 local cache的 比賽資料 包含盤口的設定
     * 
     */
    public void syncRole() {
        Connection conn = null;
        try {
            conn = DataSourceUtil.getSlaveConnection();
            // get all column or get other dao method
            List<Role> result = roleDAO.getRoleList(conn);
            if (result.size() > 0) {
                for (Role role : result) {
                    setRole(role.getId(), role);
                }
            }
        } catch (Exception e) {
            LogUtil.getWebInfoLogger().info("[RoleSync][MEDIUM]:" + e.getMessage());
        } finally {
            DbUtils.close(conn);
        }
    }
}

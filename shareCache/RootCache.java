package com.sp.platform.shareCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import com.google.common.cache.Cache;
import com.google.common.cache.LoadingCache;
import com.sp.commons.util.SerializeUtil;
import com.sp.commons.util.StringUtil;
import com.sp.db.redis.JedisUtil;
import redis.clients.jedis.Jedis;

public class RootCache {
    public String setObject(int redisDB, String key, Object obj) {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            // if success, return "OK"
            return jedis.set(key.getBytes(), SerializeUtil.serialize(obj));
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public String setString(int redisDB, String key, String obj) {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            // if success, return "OK"
            return jedis.set(key, obj);
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public String setObject(int redisDB, String key, Object obj, int expire) {
        Jedis jedis = null;
        String result = "";
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            // if success, return "OK"
            result = jedis.set(key.getBytes(), SerializeUtil.serialize(obj));
            jedis.expire(key.getBytes(), expire);
            return result;
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public boolean hasObject(int redisDB, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            return jedis.exists(key);
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public Object getObject(int redisDB, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            return getObject(jedis, redisDB, key);
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public Object getObject(Jedis jedis, int redisDB, String key) {
        jedis.select(redisDB);
        byte[] bytes = jedis.get(key.getBytes());
        if (bytes == null) {
            return null;
        } else {
            return SerializeUtil.unserialize(bytes);
        }
    }

    public String getString(int redisDB, String str) {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            String result = jedis.get(str);
            if (StringUtil.isEmpty(str)) {
                return null;
            } else {
                return result;
            }
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public boolean deleteObj(int redisDB, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            return jedis.del(key) == 1;
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public String flushDB(int redisDB) {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            return jedis.flushDB();
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public List<Object> getAllObject(int redisDB) {
        List<Object> result = null;
        Jedis jedis = null;
        try {
            result = new ArrayList<Object>();
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            Set<String> keys = jedis.keys("*");
            for (String key : keys) {
                result.add(getObject(redisDB, key));
            }
            return result;
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public List<String> getAllString(int redisDB) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            Set<String> keys = jedis.keys("*");
            if (null != keys && keys.size() > 0) {
                result = new ArrayList<String>();
                for (String key : keys) {
                    result.add(getString(redisDB, key));
                }
            }
            return result;
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public <T> List<T> getObjectByPattern(int redisDB, String pattern, Class<T> clazz) {
        List<T> result = null;
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            Set<String> keys = jedis.keys(pattern);
            if (null != keys && keys.size() > 0) {

                result = new ArrayList<T>();
                for (String key : keys) {
                    result.add((T) getObject(redisDB, key));
                }
            }
            return result;
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public List<String> getStringByPattern(int redisDB, String pattern) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            Set<String> keys = jedis.keys(pattern);
            if (null != keys && keys.size() > 0) {
                result = new ArrayList<String>();
                for (String key : keys) {
                    result.add(getString(redisDB, key));
                }
            }
            return result;
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
    }

    public Double incrByFloat(int redisDB, String key, double increment) {
        Jedis jedis = null;
        Double result = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            result = jedis.incrByFloat(key, increment);
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
        return result;
    }

    public Long incrBy(int redisDB, String key, long increment) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = JedisUtil.getJedis();
            jedis.select(redisDB);
            result = jedis.incrBy(key, increment);
        } finally {
            if (null != jedis) {
                JedisUtil.returnJedis2Pool(jedis);
            }
        }
        return result;
    }

    protected <K, T> void setLocalObject(LoadingCache<K, T> cache, K key, T obj) {
        // handle exception
        cache.put(key, obj);
    }

    protected <K, T> T getLocalObject(LoadingCache<K, T> cache, K key) throws ExecutionException {
        return cache.get(key);
    }

    protected <K, T> void setLocalObject(Cache<K, T> cache, K key, T obj) {
        // handle exception
        cache.put(key, obj);
    }

    protected <K, T> T getLocalObject(Cache<K, T> cache, K key) {
        return cache.getIfPresent(key);
    }
}

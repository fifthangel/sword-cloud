package com.sword.cloud.manager;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 *@description:缓存管理类：封装了ehcache 和reids
 *
 *@author Sjh
 *@date 2019/1/15 17:03
 *@version 1.0.1
 */

public class MyCacheManager implements CacheManager {

    //reids 实例
    private CacheManager redisCacheManager;
    //ehcache 实例
    private CacheManager ehCacheManager;

    //使用缓存前缀
    private final static String redisPrefix = "redis";

    /**
     *@description:缓存简单工厂，返回缓存实例
     *
     *@param
     *@author Sjh
     *@date 2019/1/15 17:07
     *@return
     *@version 1.0.1
     */
    @Override
    public Cache getCache(String name) {
        if (name.startsWith(redisPrefix)) {
            return redisCacheManager.getCache(name);
        } else {
            return ehCacheManager.getCache(name);
        }
    }


    /**
     *@description:
     *
     *@param
     *@author Sjh
     *@date 2019/1/15 17:06
     *@return
     *@version 1.0.1
     */
    @Override
    public Collection<String> getCacheNames() {
        Collection<String> cacheNames = new ArrayList<String>();
        if (redisCacheManager != null) {
            cacheNames.addAll(redisCacheManager.getCacheNames());
        }
        if (ehCacheManager != null) {
            cacheNames.addAll(ehCacheManager.getCacheNames());
        }
        return cacheNames;
    }

    /**
     *@description:获取缓存名称集合
     *
     *@param
     *@author Sjh
     *@date 2019/1/15 17:06
     *@return
     *@version 1.0.1
     */
    public CacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    public void setRedisCacheManager(CacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }

    public CacheManager getEhCacheCacheManager() {
        return ehCacheManager;
    }

    public void setEhCacheCacheManager(CacheManager ehcacheCacheManager) {
        this.ehCacheManager = ehcacheCacheManager;
    }


}
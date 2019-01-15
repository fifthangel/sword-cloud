package com.sword.cloud.config;

import com.sword.cloud.manager.MyCacheManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.net.URISyntaxException;

/**
 *@description: cache自动配置类
 *
 *@author Sjh
 *@date 2019/1/15 17:02
 *@version 1.0.1
 */

@EnableCaching
@SuppressWarnings({"rawtypes", "unchecked"})
public class CacheConfig {

    @Bean("redisCacheManager")
    public RedisCacheManager redisCacheManager(@Qualifier("redisTemplate") RedisTemplate redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return new RedisCacheManager(redisTemplate);
    }

    @Bean("jCacheCacheManager")
    public JCacheCacheManager jCacheCacheManager() throws URISyntaxException {
        CachingProvider provider = Caching.getCachingProvider();
        JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
        javax.cache.CacheManager eh107CacheManager = provider.getCacheManager(getClass().getResource("/config/ehcache.xml").toURI(), getClass().getClassLoader());
        jCacheCacheManager.setCacheManager(eh107CacheManager);
        return jCacheCacheManager;
    }

    @Bean("cacheManager")
    @Primary
    public CacheManager initMixCacheManager(RedisCacheManager redisCacheManager, JCacheCacheManager ehCacheManager) {
        MyCacheManager cacheManager = new MyCacheManager();
        cacheManager.setRedisCacheManager(redisCacheManager);
        cacheManager.setEhCacheCacheManager(ehCacheManager);
        return cacheManager;
    }

    /**
     * 实例化 HashOperations 对象,可以使用 Hash 类型操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    /**
     * 实例化 ValueOperations 对象,可以使用 String 操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 实例化 ListOperations 对象,可以使用 List 操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * 实例化 SetOperations 对象,可以使用 Set 操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * 实例化 ZSetOperations 对象,可以使用 ZSet 操作
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}

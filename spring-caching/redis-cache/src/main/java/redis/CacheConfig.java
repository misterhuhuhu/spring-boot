package redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

import static org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class CacheConfig implements CachingConfigurer {
    
    //    @Bean
//    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//        return (builder) -> builder
//                .withCacheConfiguration("itemCache",
//                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
//                .withCacheConfiguration("customerCache",
//                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
//    }
    
    private CacheManager cacheManager;
    
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                       .entryTtl(Duration.ofMinutes(60))
                       .disableCachingNullValues()
                       .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
                       .serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()));
    }
    
    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory, RedisCacheConfiguration redisCacheConfiguration) {
        this.cacheManager = RedisCacheManager.builder(connectionFactory).cacheDefaults(redisCacheConfiguration).build();
        return cacheManager;
    }
    
    @Override
    public CacheManager cacheManager() {
        return cacheManager;
    }
    
    @Override
    public CacheResolver cacheResolver() {
        return new CustomerRedisCacheResolver(cacheManager);
    }
    
    @Override
    public KeyGenerator keyGenerator() {
        return new CustomerCacheKeyGenerator(cacheManager);
    }
    
    @Override
    public CacheErrorHandler errorHandler() {
        return CachingConfigurer.super.errorHandler();
    }
    
}
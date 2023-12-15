package redis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class CustomerRedisCacheResolver implements CacheResolver {
    
    private final CacheManager redisCacheManager;
    
    public CustomerRedisCacheResolver(CacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }
    
    //可以重写解析,即使用缓存时,用什么key取出redis缓存
    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        
        Collection<Cache> caches = new ArrayList<>();
        Cacheable annotation = context.getMethod().getAnnotation(Cacheable.class);
        String string = "";
        if (!Objects.isNull(annotation)) {
            string = Arrays.toString(annotation.value());
        }
        log.info("annotation value = {}\n", string);
        log.info("MethodName = {}\n", context.getMethod().getName());//方法名
        log.info("Target = {}\n", context.getTarget());//类路径
        log.info("operation = {}\n", context.getOperation()); // Builder[public redis.Item redis.ItemService.getItemForId(java.lang.String)]
        log.info("args = {}\n", Arrays.toString(context.getArgs()));
        Class<?> clz = context.getMethod().getReturnType();
        if (List.class.isAssignableFrom(clz)) {
        
        }
        log.info("CacheNames {}", String.join(";", redisCacheManager.getCacheNames()));
        
        caches.add(redisCacheManager.getCache(string));
        return caches;
    }
}

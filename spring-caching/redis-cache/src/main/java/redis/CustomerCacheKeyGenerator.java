package redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class CustomerCacheKeyGenerator implements KeyGenerator {
    
    private CacheManager cacheManager;
    
    public CustomerCacheKeyGenerator(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
    
    @Override
    public Object generate(Object target, Method method, Object... params) {
        String className = target.getClass().getName();
        log.info("target : type={}, value={}", className, target);
        Cacheable annotation = method.getAnnotation(Cacheable.class);
        String annotationValueString = "";
        if (!Objects.isNull(annotation)) {
            annotationValueString = Arrays.toString(annotation.value());
            log.info("annotation value: {}", annotationValueString);
        }
        String paramsString = Arrays.toString(params);
        log.info("params {}", paramsString);
        
        return className.concat("." + method.getName()).concat((Strings.isNotBlank(annotationValueString) ? "." + annotationValueString : "")).concat("." + paramsString);
    }
    private  static String  formatGenerateKey(Method method){
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        Cacheable annotation = method.getAnnotation(Cacheable.class);
        String annotationValueString = "";
        if (!Objects.isNull(annotation)) {
            annotationValueString = Arrays.toString(annotation.value());
        }
        return className.concat("." + methodName).concat((Strings.isNotBlank(annotationValueString) ? "." + annotationValueString : ""));
    }
}

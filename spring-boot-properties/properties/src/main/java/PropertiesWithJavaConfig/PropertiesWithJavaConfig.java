package PropertiesWithJavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:foo.properties")
@PropertySource("classpath:bar.properties")
/**
 * 多个属性
 */
public class PropertiesWithJavaConfig {
    
    
    public PropertiesWithJavaConfig() {
        super();
    }
    
    // beans
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
}
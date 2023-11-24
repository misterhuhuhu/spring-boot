package BasicPropertiesWithJavaConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:foo.properties")
public class BasicPropertiesWithJavaConfig {
    
    @Value("${key.something}")
    private String something;
    public BasicPropertiesWithJavaConfig() {
        super();
    }
    
}
package ctx1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import parent.IHomeService;

@Configuration
@ComponentScan("ctx1")
@PropertySource("classpath:ctx1.properties")
@EnableAutoConfiguration
public class Ctx1Config {
    
    @Bean
    public IHomeService homeService() {
        return new GreetingService();
    }

}

package buildproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ComponentScan(basePackages = "com.baeldung.buildproperties")
@PropertySource("classpath:build.properties")
//@PropertySource("classpath:build.yml")
public class Application {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        BuildInfoService bean = run.getBean(BuildInfoService.class);
        System.out.println(bean);
    }
    
}

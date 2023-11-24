package json.factory;

import json.contextInitializer.JsonPropertyContextInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigPropertiesDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplicationBuilder(ConfigPropertiesDemoApplication.class)
                                                     .run();
        JsonProperties bean = run.getBean(JsonProperties.class);
        System.out.println(bean);
        
    }

}

package json.contextInitializer;

import json.factory.JsonProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigPropertiesDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplicationBuilder(ConfigPropertiesDemoApplication.class)
                                                     .initializers(new JsonPropertyContextInitializer())
                                                     .run();
        CustomJsonProperties bean = run.getBean(CustomJsonProperties.class);
        System.out.println(bean);
        
    }

}

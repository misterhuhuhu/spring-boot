package configurationproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableConfigurationProperties(ConfigProperties.class)//激活指定文件,不可与@Configuration一起使用
@ConfigurationPropertiesScan// ImmutableCredentials需要使用
public class EnableConfigurationDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(EnableConfigurationDemoApplication.class, args);
        ConfigProperties bean = run.getBean(ConfigProperties.class);
        Item item = run.getBean(Item.class);
        PropertyConversion propertyConversion = run.getBean(PropertyConversion.class);
        ImmutableCredentials immutableCredentials = run.getBean(ImmutableCredentials.class);
        System.out.println(bean.getPort());
        System.out.println(bean.getFrom());
        System.out.println(bean.getHostName());
        System.out.println(bean.getHostName());
    }
    
    @Bean
    @ConfigurationProperties(prefix = "item")
    public Item item() {
        return new Item();
    }
}

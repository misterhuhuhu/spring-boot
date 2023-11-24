package yamllist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import yamllist.pojo.ApplicationProps;

@SpringBootApplication
public class YamlListApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(YamlListApplication.class, args);
        ApplicationProps bean = run.getBean(ApplicationProps.class);
        System.out.println(bean);
    }

}

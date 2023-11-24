package yamlmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import yamlmap.pojo.ServerProperties;

@SpringBootApplication
public class MapFromYaml {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MapFromYaml.class, args);
        ServerProperties bean = run.getBean(ServerProperties.class);
        System.out.println(bean);
        
    }

}

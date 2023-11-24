package startup.postconstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootApplication.class, args);
        PostConstructExampleBean bean = run.getBean(PostConstructExampleBean.class);
    }

}

package startup.initializingbean;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import startup.postconstruct.PostConstructExampleBean;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootApplication.class, args);
        InitializingBeanExampleBean bean = run.getBean(InitializingBeanExampleBean.class);
    }

}

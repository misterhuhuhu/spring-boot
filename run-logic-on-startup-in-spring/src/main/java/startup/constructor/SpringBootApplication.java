package startup.constructor;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import startup.initializingbean.InitializingBeanExampleBean;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootApplication.class, args);
        LogicInConstructorExampleBean bean = run.getBean(LogicInConstructorExampleBean.class);
    }

}

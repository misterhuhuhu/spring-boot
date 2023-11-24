package startup.initmethod;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootApplication.class, args);
        InitMethodExampleBean bean = run.getBean(InitMethodExampleBean.class);
    }

}

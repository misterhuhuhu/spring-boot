package startup.combine;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import startup.applicationlistener.StartupApplicationListenerExample;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootApplication.class, args);
        AllStrategiesExampleBean bean = run.getBean(AllStrategiesExampleBean.class);
    }

}

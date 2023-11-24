package conditionalonproperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NotificationApplication {

    public static void main(String[] args) {
        System.setProperty("notification.service","email");
        System.setProperty("notification.service","sms");
        ConfigurableApplicationContext run = SpringApplication.run(NotificationApplication.class, args);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}

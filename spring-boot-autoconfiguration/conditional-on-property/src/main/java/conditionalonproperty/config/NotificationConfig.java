package conditionalonproperty.config;


import conditionalonproperty.service.EmailNotification;
import conditionalonproperty.service.NotificationSender;
import conditionalonproperty.service.SmsNotification;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean(name = "emailNotification")
    @ConditionalOnProperty(prefix = "notification", name = "service", havingValue = "email")
    public NotificationSender notificationSender() {
        return new EmailNotification();
    }

    @Bean(name = "smsNotification")
    @ConditionalOnProperty(prefix = "notification", name = "service", havingValue = "sms")
    public NotificationSender notificationSender2() {
        return new SmsNotification();
    }

}

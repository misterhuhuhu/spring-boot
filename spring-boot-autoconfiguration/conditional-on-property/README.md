## [NotificationConfig.java](src%2Fmain%2Fjava%2Fconditionalonproperty%2Fconfig%2FNotificationConfig.java)
```
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
```
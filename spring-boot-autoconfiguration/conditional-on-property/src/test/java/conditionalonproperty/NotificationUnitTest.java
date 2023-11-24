package conditionalonproperty;

import conditionalonproperty.config.NotificationConfig;
import conditionalonproperty.service.EmailNotification;
import conditionalonproperty.service.NotificationSender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationUnitTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void whenValueSetToEmail_thenCreateEmailNotification() {
        this.contextRunner.withPropertyValues("notification.service=email")
            .withUserConfiguration(NotificationConfig.class)
            .run(context -> {
                assertThat(context).hasBean("emailNotification");
                NotificationSender notificationSender = context.getBean(EmailNotification.class);
                assertThat(notificationSender.send("Hello From Baeldung!")).isEqualTo("Email Notification: Hello From Baeldung!");
                assertThat(context).doesNotHaveBean("smsNotification");
            });
    }
}

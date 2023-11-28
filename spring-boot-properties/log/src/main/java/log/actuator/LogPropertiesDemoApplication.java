package log.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class LogPropertiesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogPropertiesDemoApplication.class, args);
    }

}

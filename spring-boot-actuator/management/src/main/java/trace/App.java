package trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
    }
    
}

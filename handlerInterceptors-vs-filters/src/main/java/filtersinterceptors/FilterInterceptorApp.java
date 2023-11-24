package filtersinterceptors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "filtersinterceptors")
public class FilterInterceptorApp {
    public static void main(String[] args) {
        SpringApplication.run(FilterInterceptorApp.class, args);
    }
}
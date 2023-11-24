package lists;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:lists.properties")
public class SpringListPropertiesApplication {

}

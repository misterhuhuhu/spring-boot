package startup.initmethod;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("startup.initmethod")
public class SpringStartupConfig {
    @Resource
    private Environment environment;
    @Bean(initMethod="init")
    public InitMethodExampleBean initMethodExampleBean() {
        return new InitMethodExampleBean();
    }
}
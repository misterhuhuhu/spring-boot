package autoconfiguration;

import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)//最高优先级
public class MySQLAutoconfiguration {
    
    @Resource
    private Environment env;
    
    public MySQLAutoconfiguration() {
        System.out.println("自动配置");
        System.out.println("env" + env);
        
    }
}

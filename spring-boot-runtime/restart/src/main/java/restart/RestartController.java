package restart;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RestartController {
    
    @Resource
    private RestartService restartService;
    @Resource
    private ConfigurableApplicationContext context;
    @Resource
    private ContextRefresher contextRefresher;
    
    
    @PostMapping("/restart")
    public void restart() {
        Application.restart();
    }
    
    @PostMapping("/restartApp")
    public void restartUsingActuator() {
        restartService.restartApp();
    }
    
    /**
     * 不能使用,会使程序暂停
     */
    @PostMapping("/refresh")
    public void refresh() {
        context.refresh();
    }
    @PostMapping("/contextRefresher")
    public  Set<String> contextRefresher() {
        return contextRefresher.refresh();
    }
    
}

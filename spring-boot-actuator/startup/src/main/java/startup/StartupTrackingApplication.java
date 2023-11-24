package startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.metrics.buffering.StartupTimeline;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class StartupTrackingApplication {
    
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StartupTrackingApplication.class);
        BufferingApplicationStartup startup  = new BufferingApplicationStartup(20480);
        //过滤启动事件 addFilter方法仅检测具有指定名称的步骤
        startup.addFilter(startupStep -> startupStep.getName().matches("spring.beans.instantiate"));
        startup.addFilter(startupStep -> {
            startupStep.getTags().forEach(k-> System.out.println(k.getValue()));
            return true;
        });
        app.setApplicationStartup(startup );
        app.run(args);
    }
}

package buildproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:build.properties")
public class BuildInfoService {
    @Value("${application-description}")
    private String applicationDescription;
    
    @Value("${application-version}")
    private String applicationVersion;

    public String getApplicationDescription() {
        return applicationDescription;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }
}

package startup.initmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class InitMethodExampleBean {
    
    private static final Logger LOG = LoggerFactory.getLogger(InitMethodExampleBean.class);
    
    @Autowired
    private Environment environment;
    
    public void init() {
        LOG.info("Env Default Profiles : {}", Arrays.asList(environment.getDefaultProfiles()));
    }
}

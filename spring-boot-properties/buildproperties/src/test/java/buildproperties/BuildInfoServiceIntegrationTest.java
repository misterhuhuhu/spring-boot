package buildproperties;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = Application.class)
class BuildInfoServiceIntegrationTest {
    
    @Autowired
    private BuildInfoService service;
    
    @Test
    void whenGetApplicationDescription_thenSuccess() {
        Logger logger = LoggerFactory.getLogger(BuildInfoServiceIntegrationTest.class);
        logger.info(service.getApplicationDescription());
        logger.info(service.getApplicationVersion());
    }
}

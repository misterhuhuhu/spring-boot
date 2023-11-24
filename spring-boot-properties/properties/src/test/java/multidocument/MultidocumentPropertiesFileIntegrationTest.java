package multidocument;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("default")
@SpringBootTest(classes = { MultidocumentTestConfig.class })
public class MultidocumentPropertiesFileIntegrationTest {

    Logger logger = LoggerFactory.getLogger(MultidocumentPropertiesFileIntegrationTest.class);

    @Value("${baeldung.customProperty}")
    private String customProperty;
    
    @Resource
    private Environment environment;
    @Test
    public void givenMultidocumentPropertiesFileWhenBootContextLoadedThenDocumentProcessedCorrectly() {
        logger.info(customProperty);
        String[] defaultProfiles = environment.getActiveProfiles();
        Arrays.stream(defaultProfiles).forEach(logger::info);
    }
}

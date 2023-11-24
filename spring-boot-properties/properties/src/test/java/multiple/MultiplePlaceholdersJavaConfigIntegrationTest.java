package multiple;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest( classes = {PropertySourcesPlaceholderConfig.PropertySourcesPlaceholderConfig.class} )
public class MultiplePlaceholdersJavaConfigIntegrationTest {

    @Value("${key.something}")
    private String something;


    @Test
    public void whenReadInjectedValues_thenGetCorrectValues() {
        assertThat(something).isEqualTo("val");
    }
    
    
}
import annotationprocessor.AnnotationProcessorApplication;
import annotationprocessor.DatabaseProperties;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DatabaseProperties.class,loader = AnnotationConfigContextLoader.class)
@TestPropertySource("classpath:databaseproperties-test.properties")
public class DatabasePropertiesIntegrationTest {
    
    @Resource
    private DatabaseProperties databaseProperties;
    
    @Test
    public void whenSimplePropertyQueriedThenReturnsPropertyValue() throws Exception {
        System.out.println(databaseProperties.getUsername());
        System.out.println(databaseProperties.getPassword());
        
    }
    
    @Test
    public void whenNestedPropertyQueriedThenReturnsPropertyValue() throws Exception {
        System.out.println(databaseProperties.getServer().getIp());
        System.out.println(databaseProperties.getServer().getPort());
        
    }
    
}

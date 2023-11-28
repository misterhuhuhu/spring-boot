package exclude;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExcludeAutoConfig4IntegrationTest {
    
    /**
     * Encapsulates the random port the test server is listening on.
     */
    @LocalServerPort
    private int port;
    
    @Test
    public void givenSecurityConfigExcluded_whenAccessHome_thenNoAuthenticationRequired() {
    
    }
}

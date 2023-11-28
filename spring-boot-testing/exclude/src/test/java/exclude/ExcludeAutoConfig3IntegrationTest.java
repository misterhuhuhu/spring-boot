package exclude;


import boot.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
public class ExcludeAutoConfig3IntegrationTest {

    /**
     * Encapsulates the random port the test server is listening on.
     */
    @LocalServerPort
    private int port;

    @Test
    public void givenSecurityConfigExcluded_whenAccessHome_thenNoAuthenticationRequired() {

    }
}

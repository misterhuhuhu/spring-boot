package configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "mail.credentials")
//@Configuration//不能使用
public class ImmutableCredentials {

    private final String authMethod;
    private final String username;
    private final String password;

    @ConstructorBinding
    public ImmutableCredentials(String authMethod, String username, String password) {
        this.authMethod = authMethod;
        this.username = username;
        this.password = password;
    }

    public ImmutableCredentials(String username, String password) {
        this.username = username;
        this.password = password;
        this.authMethod = "Default";
    }

    public String getAuthMethod() {
        return authMethod;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

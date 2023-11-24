package configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties") //这标注使用哪个配置文件
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {
    
    private String hostName;
    private int port;
    private String from;
    private Credentials credentials;//嵌套属性
  
    private List<String> defaultRecipients;//嵌套属性
    private Map<String, String> additionalHeaders;//嵌套属性
    
    public String getHostName() {
        return hostName;
    }
    public List<String> getDefaultRecipients() {
        return defaultRecipients;
    }
    
    public ConfigProperties setDefaultRecipients(List<String> defaultRecipients) {
        this.defaultRecipients = defaultRecipients;
        return this;
    }
    
    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }
    
    public ConfigProperties setAdditionalHeaders(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
        return this;
    }
    
    public Credentials getCredentials() {
        return credentials;
    }
    
    public ConfigProperties setCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }
    
    public ConfigProperties setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }
    
    public int getPort() {
        return port;
    }
    
    public ConfigProperties setPort(int port) {
        this.port = port;
        return this;
    }
    
    public String getFrom() {
        return from;
    }
    
    public ConfigProperties setFrom(String from) {
        this.from = from;
        return this;
    }
}
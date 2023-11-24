package json.contextInitializer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "custom")
public class CustomJsonProperties {

    private String host;

    private int port;

    private boolean resend;

    private Person sender;

    public static class Person {

        private String name;
        private String address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        
        @Override
        public String toString() {
            return "Person{" +
                           "name='" + name + '\'' +
                           ", address='" + address + '\'' +
                           '}';
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isResend() {
        return resend;
    }

    public void setResend(boolean resend) {
        this.resend = resend;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }
    
    @Override
    public String toString() {
        return "CustomJsonProperties{" +
                       "host='" + host + '\'' +
                       ", port=" + port +
                       ", resend=" + resend +
                       ", sender=" + sender +
                       '}';
    }
}

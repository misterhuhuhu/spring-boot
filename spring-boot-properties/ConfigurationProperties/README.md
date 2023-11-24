## 属性验证
@ConfigurationProperties使用 JSR-380 格式提供属性验证

```java
@Configuration
@PropertySource("classpath:configprops.properties")
@ConfigurationProperties(prefix = "mail")
@Validated
public class ConfigProperties {

    @Validated
    public static class Credentials {

        @Length(max = 4, min = 1)
        private String authMethod;
        private String username;
        private String password;

       // getter setter
    }

    @NotBlank
    private String hostName;

    @Min(1025)
    @Max(65536)
    private int port;

    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String from;
}
```
## 属性转换
[PropertyConversion.java](src%2Fmain%2Fjava%2Fconfigurationproperties%2FPropertyConversion.java)
1. Duration 
2. DataSize

## 自定义转换器 
[Employee.java](src%2Fmain%2Fjava%2Fconfigurationproperties%2FEmployee.java)
## Immutable @ConfigurationProperties
不使用setter，使用构造函数,字段都是final
[ImmutableCredentials.java](src%2Fmain%2Fjava%2Fconfigurationproperties%2FImmutableCredentials.java)
## java17 record
```java
@ConstructorBinding
@ConfigurationProperties(prefix = "mail.credentials")
public record ImmutableCredentials(String authMethod, String username, String password) {
}
```
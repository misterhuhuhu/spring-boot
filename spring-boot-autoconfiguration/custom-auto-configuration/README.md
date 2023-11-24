## 创建自定义 Spring Boot Auto Configuration

1. 创建自定义自动配置
    ```
    @Configuration
    @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)//最高优先级
    public class MySQLAutoconfiguration {
        //...
    }
    ```
2. 在 /resources/META-INF/spring 下新建 org.springframework.boot.autoconfigure.AutoConfiguration.imports 
<br>,并填写配置类限定名[autoconfiguration.MySQLAutoconfiguration]
   > 现在3.0中【META-INF/spring.factories】已被移除
3. 禁用自动配置类
   ```
   @Configuration
   @EnableAutoConfiguration(
     exclude={MySQLAutoconfiguration.class})
   public class AutoconfigurationApplication {
       //...
   }
   ```
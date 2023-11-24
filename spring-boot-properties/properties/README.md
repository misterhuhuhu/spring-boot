## 注释注册属性文件
1.
    ```java
    @Configuration
    @PropertySource("classpath:foo.properties")
    public class PropertiesWithJavaConfig {
        //...
    }
    ```
2. 使用占位符，它允许我们在运行时动态选择正确的文件
    ```java
    @PropertySource({ 
      "classpath:persistence-${envTarget:mysql}.properties"
    })
    public class PropertiesWithJavaConfig {
        //...
    }
    ```
3. 注入带有 @Value 注解的属性
    ``` 
    @Value( "${jdbc.url}" )
    private String jdbcUrl;
    
    @Value( "${jdbc.url:aDefaultUrl}" )
    private String jdbcUrl;
    ```
## Spring Boot 的属性
1. application.properties：默认属性文件
2. 特定于测试的属性文件
   - Spring Boot 通过在测试运行期间查看 src/test/resources 目录来为我们处理这个问题。同样，默认属性仍将正常注入，但如果发生冲突，则会被这些属性覆盖。
3. @TestPropertySource注解
   - 如果我们需要对测试属性进行更精细的控制，则可以使用 @TestPropertySource 注解。
     这允许我们为特定的测试上下文设置测试属性，优先于默认属性源：
       ```
       @RunWith(SpringRunner.class)
       @TestPropertySource("/foo.properties")
       public class FilePropertyInjectionUnitTest {
    
           @Value("${foo}")
           private String foo;
    
           @Test
           public void whenFilePropertyProvided_thenProperlyInjected() {
               assertThat(foo).isEqualTo("bar");
           }
       }
       ```
   - 如果我们不想使用文件，我们可以直接指定名称和值：
     ```
      @RunWith(SpringRunner.class)
      @TestPropertySource(properties = {"foo=bar"})
      public class PropertyInjectionUnitTest {
      
          @Value("${foo}")
          private String foo;
      
          @Test
          public void whenPropertyProvided_thenProperlyInjected() {
              assertThat(foo).isEqualTo("bar");
          }
      }
     ```
   - 可以使用 @SpringBootTest 注解的 properties 参数来实现类似的效果
     ```
     @RunWith(SpringRunner.class)
     @SpringBootTest(
     properties = {"foo=bar"}, classes = SpringBootPropertiesTestApplication.class)
     public class SpringBootPropertyInjectionIntegrationTest {
     
     @Value("${foo}")
     private String foo;
     
      @Test
      public void whenSpringBootPropertyProvided_thenProperlyInjected() {
       assertThat(foo).isEqualTo("bar");
      }
     }
     ```
4. @ConfigurationProperties(prefix = "database") 
    - 带前缀
      - ```
        database.url=jdbc:postgresql:/localhost:5432/instance
        database.username=foo
        database.password=bar
        ```
## 导入其他配置文件
1. 2.4.0 之前，Spring Boot 允许使用 spring.config.location 和 spring.config.additional-location 属性包含其他配置文件
2. 可以在application.properties或application.yml文件中使用spring.config.import属性来轻松包含其他文件
    - 添加多个文件或目录
    - 可以从类路径或外部目录加载这些文件
    - 指示如果找不到文件，或者启动过程是否应失败，或者它是否为可选文件
    - 导入无扩展名文件
## 命令行参数中的属性
- java -jar app.jar --property="value"
- java -Dproperty.name="value" -jar app.jar
## 环境变量中的属性
```
export name=value
java -jar app.jar
```
## 属性值的随机化
使用 RandomValuePropertySource 来随机化属性的值
```
random.number=${random.int}
random.long=${random.long}
random.uuid=${random.uuid}
```
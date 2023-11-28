# 在 Spring Boot 测试中排除自动配置类
1. 使用@EnableAutoConfiguration ,使用 exclude 属性排除了 SecurityAutoConfiguration 类，但我们可以对任何自动配置类执行相同的操作
    [ExcludeAutoConfig3IntegrationTest.java](src%2Ftest%2Fjava%2Fexclude%2FExcludeAutoConfig3IntegrationTest.java)
2. 使用@TestPropertySource,使用 @TestPropertySource 注入属性“spring.autoconfigure.exclude”
       [ExcludeAutoConfig1IntegrationTest.java](src%2Ftest%2Fjava%2Fexclude%2FExcludeAutoConfig1IntegrationTest.java)
3.  使用配置文件 
    [ExcludeAutoConfig2IntegrationTest.java](src%2Ftest%2Fjava%2Fexclude%2FExcludeAutoConfig2IntegrationTest.java)
    ,并在 application-test.properties 中包含所有特定于“测试”配置文件的属性 
    > spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration 

4. 使用自定义测试配置   
    [ExcludeAutoConfig4IntegrationTest.java](src%2Ftest%2Fjava%2Fexclude%2FExcludeAutoConfig4IntegrationTest.java)
    [TestApplication.java](src%2Ftest%2Fjava%2Fexclude%2FTestApplication.java)

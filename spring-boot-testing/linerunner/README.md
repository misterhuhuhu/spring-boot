## 阻止 ApplicationRunner 或 CommandLineRunner Bean 在 Junit 测试期间执行
1. 通过Spring Profiles 
   - > @Profile("!test")
2. 通过 ConditionalOnProperty 注解
    - > @ConditionalOnProperty(
      prefix = "application.runner",
      value = "enabled",
      havingValue = "true",
      matchIfMissing = true) //[ApplicationRunnerTaskExecutor.java](src%2Fmain%2Fjava%2Fexecution%2FApplicationRunnerTaskExecutor.java)
    - > @ConditionalOnProperty(
      prefix = "command.line.runner",
      value = "enabled",
      havingValue = "true",
      matchIfMissing = true) //[CommandLineTaskExecutor.java](src%2Fmain%2Fjava%2Fexecution%2FCommandLineTaskExecutor.java)
    - > @SpringBootTest(properties = {
      "command.line.runner.enabled=false",
      "application.runner.enabled=false" })

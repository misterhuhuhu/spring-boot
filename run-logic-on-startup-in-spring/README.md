## 启动时执行逻辑
1. @PostConstruct注解
    
2. InitializingBean 接口
3. ApplicationListener
   > 初始化 Spring 上下文后使用此方法运行逻辑。所以，我们并不关注任何特定的bean。相反，我们正在等待它们全部初始化
4. @Bean initMethod 属性
5. 构造函数注入
6. Spring Boot CommandLineRunner
7. Spring Boot ApplicationRunner 
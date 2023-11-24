1. @SpringBootApplication
    
    > 标记 Spring Boot 应用程序的主类
    ```
    @SpringBootApplication
    class VehicleFactoryApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(VehicleFactoryApplication.class, args);
        }
    }   
    ```
2. @EnableAutoConfiguration
   > 启用自动配置。这意味着Spring Boot 在其类路径上查找自动配置 bean并自动应用它们。
    ```
    @Configuration
    @EnableAutoConfiguration
    class VehicleFactoryConfig {}
    ```
3. 条件自动配置
   1. @ConditionalOnClass和@ConditionalOnMissingClass
      > 如果注释参数中的类存在/不存在， Spring 将仅使用标记的自动配置 bean
      ```
      @Configuration
      @ConditionalOnClass(DataSource.class)
      class MySQLAutoconfiguration {
      //...
      }      
      ```        
   2. @ConditionalOnBean和@ConditionalOnMissingBean
      > 如果注释参数中特定 bean 存在/不存在， Spring 将仅使用标记的自动配置 bean
         ```
         @Bean
         @ConditionalOnBean(name = "dataSource")
         LocalContainerEntityManagerFactoryBean entityManagerFactory() {}
         ```
4. @ConditionalOnProperty
   > 可以对属性的值设置条件
   ```
   @Bean
   @ConditionalOnProperty(name = "usemysql", havingValue = "local")
   DataSource dataSource() {
     DriverManagerDataSource dataSource = new DriverManagerDataSource();
     dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
     dataSource.setUrl("jdbc:hsqldb:mem:testdb");
     dataSource.setUsername( "sa" );
     dataSource.setPassword( "" );
     return dataSource;
   }
   ```
5. @ConditionalOnResource
   >  Spring 仅在存在特定资源时才使用定义
   ```
   @ConditionalOnResource(resources = "classpath:mysql.properties")
   Properties additionalProperties() {
   // ...
   }
   ```
6. @ConditionalOnWebApplication和@ConditionalOnNotWebApplication
   > 根据当前应用程序是否是 Web 应用程序来创建
7. @ConditionalExpression
   ``` 
   当SpEL 表达式求值为 true时，Spring 将使用标记的定义
   @Bean
   @ConditionalOnExpression("${usemysql} && ${mysqlserver == 'local'}")
   DataSource dataSource() {
   // ...
   }
   ```
8. @Conditional
   ```
   //自定义条件
   public class ConditionalBeanConfiguration {
       @Conditional(HibernateCondition.class)
       Properties additionalProperties() {
           // application specific properties
           return new Properties();
       }
   }
   public class HibernateCondition implements Condition {
      @Override
      public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
         // application specific condition check
         return true;
      }
   }   
   ```


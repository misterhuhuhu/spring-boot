## Health Indicators  (健康指标)
需要
```
management.endpoint.health.show-details=always
```
1. 内置 HealthIndicator
   1. DiskSpaceHealthIndicator 
   2. PingHealthIndicator
   3. *使用关系数据库，那么 Spring Boot 会注册 DataSourceHealthIndicator。*
   4. *使用 Cassandra 作为数据存储，它将注册 CassandraHealthIndicator*
2. 自定义HealthIndicator（react web 使用  ReactiveHealthIndicator）
   - [RandomHealthIndicator.java](src%2Fmain%2Fjava%2Fhealth%2FRandomHealthIndicator.java)
   - [WarningHealthIndicator.java](src%2Fmain%2Fjava%2Fhealth%2FWarningHealthIndicator.java)
3. 禁用 management.health.<indicator_identifier>.enabled
   ```
   management.health.random.enabled=false
   ```
>[Health Indicators in Spring Boot](https://www.baeldung.com/spring-boot-health-indicators)
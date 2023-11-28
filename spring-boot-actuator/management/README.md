## 使用 Spring Boot Actuator 的 HTTP Tracing

1. > management.endpoints.web.exposure.include=httptrace
2. 实现自定义 HttpTraceRepository
```
    @Bean
    public HttpExchangeRepository httpTraceRepository() {
        return new InMemoryHttpExchangeRepository();
    }
```
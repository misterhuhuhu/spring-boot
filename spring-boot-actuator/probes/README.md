## Liveness and Readiness

- 配置
```
management.endpoint.health.probes.enabled=true
management.health.livenessState.enabled=true
management.health.readinessState.enabled=true
```


- 访问/actuator/health/liveness和 /actuator/health/readiness端点作为我们的 liveness 和 readiness 探针

- 注册事件监听器，以便在应用程序可用性状态发生变化时收到通知
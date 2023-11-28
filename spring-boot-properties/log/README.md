# 在 Spring Boot 应用程序中查找和记录属性的不同方法
1 使用 Spring Events [event](src%2Fmain%2Fjava%2Flog%2Fevent)

2 使用环境接口记录属性 [env](src%2Fmain%2Fjava%2Flog%2Fenv)

3 Spring Actuator
        1 启用 /env     
            打开 application.properties 并添加以下条目：
            > management.endpoints.web.exposure.include=env
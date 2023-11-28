## 以编程方式重新启动 Spring Boot 应用程序

1. 通过创建新上下文重新启动 [Application.java](restart%2Fsrc%2Fmain%2Fjava%2Frestart%2FApplication.java) 
    需要启用
    ```
    management.endpoint.shutdown.enabled=true    
    ```
   否则不能重启
2. 执行器的重启端点
    > 需要配置 management.endpoint.restart.enabled=true
3. 刷新应用程序上下文

## maven配置启动参数
``` 
    <build>
        <finalName>${project.artifactId}</finalName>
        <resources>
            <resource>
                <directory>src/main/resources/heap</directory>
                <targetPath>${project.build.directory}</targetPath>
                <filtering>true</filtering>
                <includes>
                    <include>${project.name}.conf</include>
                </includes>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <configuration>
                            <mainClass>com.baeldung.heap.HeapSizeDemoApplication</mainClass>
                        </configuration>
                    </execution>
                </executions>
                <configuration>
                    <executable>true</executable>
                    <jvmArguments>
                        -Xms256m
                        -Xmx1g
                    </jvmArguments>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

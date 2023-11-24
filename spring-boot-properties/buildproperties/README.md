## 引用[pom.xml](pom.xml)中的信息

*必须先执行spring-boot：run*

```
<build>
    <finalName>spring-boot-properties</finalName>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <filtering>true</filtering>
        </resource>
    </resources>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <id>build-info</id>
                    <goals>
                        <goal>build-info</goal>
                    </goals>
                    <configuration>
                        <additionalProperties>
                            <java.version>${java.version}</java.version>
                            <description>${project.description}</description>
                            <custom.value>123</custom.value>
                        </additionalProperties>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
## 使用 YAML 文件中的构建信息
- 使用 YAML 来存储应用程序属性，我们可能无法使用 @ 来指定生成属性。这是因为 @ 是 YAML 中的保留字符
    ```
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-resources-plugin</artifactId>
        <configuration>
            <delimiters>
                <delimiter>^</delimiter>
            </delimiters>
            <useDefaultDelimiters>false</useDefaultDelimiters>
        </configuration>
    </plugin>
    ```
    或者
    ```
    <properties>
        <resource.delimiter>^</resource.delimiter>
    </properties>    
    ```

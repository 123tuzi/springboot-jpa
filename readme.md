# 记录踩的坑

## 1、Unable to open JDBC Connection for DDL execution

springboot 2.1.2 默认使用的mysql驱动版本太高(8.0+),开发用的5.7，所以在pom文件中要使用5版本的mysql驱动

```pom
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
    <version>5.1.46</version>
</dependency>
```



## 2、jdbcUrl is required with driverClassName

Spring Boot 2.0后，在配置文件中使用spring.datasource.jdbc-url，而不是通常使用的spring.datasource.url

```yml
spring:
  datasource:
    testdb:
      driver-class-name: com.mysql.jdbc.Driver
      jdbc-url: jdbc:mysql:///testdb?useUnicode=true&characterEncoding=utf-8
      username: root
      password: root
```

3、注意导入EntityManagerFactoryBuilder的包

正确的包如下：

```
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
```
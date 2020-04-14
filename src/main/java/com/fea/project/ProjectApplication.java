package com.fea.project;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableCaching
public class ProjectApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

}

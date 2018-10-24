package com.paobang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.server.core.common.DynamicDataSourceRegister;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@ComponentScan(basePackages={"com.server","com.paobang"})
@Import({DynamicDataSourceRegister.class})
public class ServerApplication {
	public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context= SpringApplication.run(ServerApplication.class, args);
    }
}

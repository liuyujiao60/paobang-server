package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
public class ServerApplication {
	public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context= SpringApplication.run(ServerApplication.class, args);
    }
}

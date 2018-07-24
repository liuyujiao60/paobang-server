package com.server.component.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by qingshengzheng on 18/1/15.
 */
@Configuration
@EnableCaching
public class JedisConfig {
    @Value("${spring.redis.host}")
    private String hostName;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.pool.max-active}")
    private int maxactive;
    @Value("${spring.redis.pool.max-wait}")
    private int maxwait;
    @Value("${spring.redis.pool.max-idle}")
    private int maxidle;
    @Value("${spring.redis.pool.min-idle}")
    private int minidle;
    @Value("${spring.redis.database}")
    private int db;

    @Bean
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxidle);
        config.setMinIdle(minidle);
        config.setMaxTotal(maxactive);
        return config;
    }
    @Bean
    public JedisPool getJedisPool() {JedisPoolConfig config = getRedisConfig();
        JedisPool pool = new JedisPool(config, hostName, port, timeout, password,db);
        return pool;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}

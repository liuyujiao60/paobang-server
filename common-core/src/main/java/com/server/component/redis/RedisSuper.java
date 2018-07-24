package com.server.component.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Created by qingshengzheng on 18/1/15.
 */
@Component
public class RedisSuper {
    @Autowired
    private  JedisPool pool;

    public  Jedis getResource(String key) {
        Jedis jedis = pool.getResource();
        int dbIndex = 0;
        if (key.startsWith("DB")) {
            dbIndex = Integer.parseInt(key.substring(0, key.indexOf("_")).replace("DB", ""));
        }
        if (jedis.getDB() != dbIndex) {
            jedis.select(dbIndex);
        }

        return jedis;
    }


}

package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("Initializing RedisTemplate");
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // Set the connection factory
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // Use String serializer for keys
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}

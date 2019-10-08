package com.center.pmit.redis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * redis-session配置
 * <p>
 * maxInactiveIntervalInSeconds:配置session过期时间,单位秒
 *
 * @author Administrator
 */
@EnableCaching
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 100,redisFlushMode = RedisFlushMode.IMMEDIATE)
@Configuration
public class RedisSessionConfig {

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        //让springSession不再执行config命令
        return ConfigureRedisAction.NO_OP;
    }
}

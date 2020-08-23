package pos.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import pos.demo.login.Entity.RedisTest;
import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object, RedisTest> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, RedisTest> template = new RedisTemplate<Object, RedisTest>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<RedisTest> json = new Jackson2JsonRedisSerializer<RedisTest>(RedisTest.class);
        template.setDefaultSerializer(json);
        return template;
    }

}

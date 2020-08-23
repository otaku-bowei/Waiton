package pos.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import pos.demo.login.Entity.ClientEntity;
import pos.demo.login.Entity.RedisTest;
import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object, ClientEntity> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, ClientEntity> template = new RedisTemplate<Object, ClientEntity>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<ClientEntity> json = new Jackson2JsonRedisSerializer<ClientEntity>(ClientEntity.class);
        template.setDefaultSerializer(json);
        return template;
    }

}

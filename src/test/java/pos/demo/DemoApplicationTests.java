package pos.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import pos.demo.login.Entity.RedisTest;
import pos.demo.login.Service.LoginService;

@SpringBootTest
@MapperScan("pos.demo.login.DAO")
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    LoginService loginService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, RedisTest> redisTemplate;

    @Test
    void mysqlTest(){
        System.out.println(loginService.getUsername("252795767@qq.com"));
    }


    @Test
    void testRedis(){
        redisTemplate.opsForValue().set("1号员工",new RedisTest("王柏伟",18,"440111199811091215"));
    }
}

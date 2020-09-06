package pos.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.InputStreamSource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ws.mime.Attachment;
import org.springframework.ws.mime.AttachmentException;
import org.springframework.ws.mime.MimeMessage;
import pos.demo.login.Entity.RedisTest;
import pos.demo.login.Service.LoginService;
import pos.demo.register.Service.RegisterService;

import javax.activation.DataHandler;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Random;

@SpringBootTest
@MapperScan("pos.demo.login.DAO")
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    JavaMailSenderImpl javaMailSender ;

    @Autowired
    LoginService loginService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RegisterService registerService ;

    @Test
    void mysqlTest(){
        System.out.println(loginService.getUsername("123456@qq.com",1));
    }


    @Test
    void registerTest(){
        boolean b = registerService.register("123456@qq.com","123456654321","注册测试",1);
        System.out.println(b);
    }


    @Test
    void mailTest(){
        registerService.sendMessage("252795767@qq.com");
    }
 }

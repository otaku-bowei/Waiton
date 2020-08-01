package pos.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pos.demo.Login.Service.LoginService;

@SpringBootTest
@MapperScan("pos.demo.Login.DAO")
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    LoginService loginService;

    @Test
    void mysqlTest(){
        System.out.println(loginService.checkPassword("252795767@qq.com",null,"wbw123."));
    }

}

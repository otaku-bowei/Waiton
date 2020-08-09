package pos.demo.Login.Service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pos.demo.Login.DAO.ClientMapper;

//@Async
@Service
@MapperScan("pos.demo.Login.DAO")
public class LoginService {

    @Autowired
    ClientMapper clientMapper;//自动配置，包内权限

    /*
    * @author 王柏伟
    * @param loginEmail  登录邮件
    * @param loginUsername  登录用户名字
    * @param password 登录输入的密码
    * @return boolean 返回该用户登录的密码是否正确，返回布尔类型
     */
    public String checkPassword(String loginEmail,String password){
        String p=clientMapper.checkPasswordByEmail(loginEmail);
        System.out.println(p);
        String s;
        if (p!=null && password.equals(p)){
            s="true";
        }else {
            s="false";
        }

        return s;

    }


}

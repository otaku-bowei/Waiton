package pos.demo.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.demo.Login.DAO.ClientMapper;


@Service
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
    public boolean checkPassword(String loginEmail,String loginUsername,String password){
        String p=loginEmail!=null?clientMapper.checkPasswordByEmail(loginEmail):clientMapper.checkPasswordByUsername(loginUsername);
        System.out.println(p);
        if (p!=null && password.equals(p)){
            return true;
        }else {
            return false;
        }

    }


}

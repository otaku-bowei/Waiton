package pos.demo.register.Service;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import pos.demo.login.DAO.ClientMapper;
import pos.demo.login.Entity.ClientEntity;
import pos.demo.register.DAO.ClientRegister;

import java.util.Random;

@Service
@MapperScan("pos.demo.register.DAO")
public class RegisterService {

    @Autowired
    ClientRegister clientRegister ;

    @Autowired
    JavaMailSenderImpl javaMailSender ;

    /*  检测该邮箱是否已经注册过
     *@author    王柏伟
     * @param    email   邮箱地址
     **/
    public boolean checkUser(String email){
        ClientEntity client = clientRegister.checkUser(email) ;
        //不存在返回true，表示可以注册
        if (client==null){
            return true ;
        }else {
            return false ;
        }
    }

    /*  数据库添加用户
     *@author    王柏伟
     * @param    email   邮箱地址
     * @param    password    密码
     * @param    username    用户名
     **/
    public boolean register(String email , String password , String username){
        boolean getRegister = clientRegister.register(email, password, username) ;
        return getRegister ;
    }

    /*  发送验证码到邮箱
     *@author    王柏伟
     * @param    email   邮箱地址
     **/
    public String sendMessage(String email){
        SimpleMailMessage smm = new SimpleMailMessage() ;
        smm.setSubject("来自Waiton的注册验证码");
        String str="abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb = new StringBuffer("") ;
        for (int i=0;i<6 ; i++){
            sb.append(str.charAt(random.nextInt(62))) ;
        } 
        smm.setText(sb.toString());
        smm.setTo(email);
        smm.setCc("defsoul_bw@163.com");
        smm.setFrom("defsoul_bw@163.com");
        javaMailSender.send(smm) ;
        return sb.toString() ;
    }
}

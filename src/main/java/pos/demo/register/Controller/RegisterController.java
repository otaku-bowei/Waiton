package pos.demo.register.Controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import pos.demo.register.Entity.Messages;
import pos.demo.register.Service.RegisterService;

import javax.servlet.http.HttpSession;

@EnableAsync
@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService ;
    
   

    //验证邮箱
    @RequestMapping(value = "checkUser",method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(@RequestParam("email") String email){
        boolean canRegister = registerService.checkUser(email) ;
        if (canRegister){
        	return "true" ;
        }else {
            return "false" ;
        }
    }

    //发送验证码
    @RequestMapping(value = "sendMessage",method = RequestMethod.POST)
    @ResponseBody
    public void sendMessage(HttpSession session , @RequestParam("email") String email){
        String message = registerService.sendMessage(email) ;
        System.out.println(message);
        Messages.messages.put(session,message);
        System.out.println(Messages.messages.get(session));
    }

    //注册邮箱，数据传到数据库记录
    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public boolean register(HttpSession session ,@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            @RequestParam("username") String username,
                            @RequestParam("message") String message){
    	System.out.println(Messages.messages.get(session));
        boolean messageRight = message.equals((String)Messages.messages.get(session)) ;
        System.out.println(email+" "+password+" "+username+" "+message+" "+messageRight+" "+Messages.messages.get(session));
        if (messageRight){
            System.out.println(email+" "+password+" "+username+" ");
            boolean getRegister = registerService.register(email, password, username);
            return getRegister ;
        }else {
            return false ;
        }

    }
}

package pos.demo.register.Controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import pos.demo.register.Service.RegisterService;

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
        	//System.out.println(email);
            String message = registerService.sendMessage(email);
            //System.out.println(message);
            return message ;
        }else {
            return "false" ;
        }
    }


    //注册邮箱，数据传到数据库记录
    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public boolean register(@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("username") String username){
    	System.out.println(email+" "+password+" "+username+" ");
    		boolean getRegister = registerService.register(email, password, username); 
    		return getRegister ;
       
    }



}

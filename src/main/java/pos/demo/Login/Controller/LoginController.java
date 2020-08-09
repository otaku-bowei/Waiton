package pos.demo.Login.Controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pos.demo.Login.Service.LoginService;


@EnableAsync
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "in")
    public ModelAndView login(ModelAndView mav){
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "index")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("index");
        return mav;
    }


    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String checkPassword(@RequestParam("username") String email, @RequestParam("password") String password){
        String s =  loginService.checkPassword(email,password);
        System.out.println(s);
        return s;
    }


}

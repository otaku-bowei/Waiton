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
@MapperScan("pos.demo.Login.DAO")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/in")
    //@Async
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("login");
        return mav;
    }

    @Async
    @RequestMapping(value = "o_test/login",method = RequestMethod.POST)
    @ResponseBody
    public boolean checkPassword(@RequestParam("username") String email, @RequestParam("password") String password){
        return loginService.checkPassword(email,null,password);
    }


}

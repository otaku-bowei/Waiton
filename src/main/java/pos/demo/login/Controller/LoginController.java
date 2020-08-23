package pos.demo.login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pos.demo.login.Entity.ClientEntity;
import pos.demo.login.Entity.RedisTest;
import pos.demo.login.Service.LoginService;

import javax.servlet.http.HttpSession;


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
    public String checkPassword(HttpSession session, @RequestParam("username") String email, @RequestParam("password") String password){
        String s =  loginService.checkPassword(email,password);
        System.out.println(s);
        session.setAttribute("user", new ClientEntity(email,password,loginService.getUsername(email)));
        return s;
    }

    @RequestMapping(value = "getUsername",method = RequestMethod.POST)
    @ResponseBody
    public String returnUsername(HttpSession session){
        String s = ((ClientEntity)session.getAttribute("user")).getUsername();
        System.out.println();
        return s;
    }

}

package pos.demo.login.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "ClientMapper")
public interface ClientMapper {

    @Select("select password from client where email=\'${loginEmail}\' ")
    public String checkPasswordByEmail(@Param("loginEmail") String loginEmail);

    @Select("select password from client where username=\'${loginUsername}\' ")
    public String checkPasswordByUsername(@Param("loginUsername") String loginUsername);

    /*
    ***根据邮箱获取用户名
    */
    @Select("select username from client where email=\'${email}\' ")
    public String getUsername(@Param("email") String email);


}

package pos.demo.login.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "ClientMapper")
public interface ClientMapper {

    @Select("select password from user where email=\'${loginEmail}\' and clientType=\'${clientType}\'")
    public String checkPasswordByEmail(@Param("loginEmail") String loginEmail,@Param("clientType") int clientType);

    @Select("select password from user where username=\'${loginUsername}\' and clientType=\'${clientType}\'")
    public String checkPasswordByUsername(@Param("loginUsername") String loginUsername,@Param("clientType") int clientType);

    /*
    ***根据邮箱获取用户名
    */
    @Select("select username from user where email=\'${email}\' and clientType=\'${clientType}\' ")
    public String getUsername(@Param("email") String email,@Param("clientType") int clientType);


}

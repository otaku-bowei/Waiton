package pos.demo.register.DAO;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pos.demo.login.Entity.ClientEntity;

@Mapper
@Component(value = "ClientRegister")
public interface ClientRegister {
    /*
    *@author    王柏伟
    * @param    email   邮箱地址
    * @param    password    密码
    * @param    username    用户名
    **/
    @Insert("insert into client(email,password,username) values(\'${email}\',\'${password}\',\'${username}\')")
    public boolean register(@Param("email") String eamil,@Param("password") String password,@Param("username") String username);

    /*  检测该邮箱是否存在
     *@author    王柏伟
     * @param    email   邮箱地址
     **/
    @Select("select * FROM client WHERE email=\'${email}\'")
    public ClientEntity checkUser(@Param("email") String email) ;




}

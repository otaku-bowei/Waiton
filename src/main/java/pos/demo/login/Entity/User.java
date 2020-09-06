package pos.demo.login.Entity;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {
    private String email;
    private String password;
    private String username;
    private int clientType ;
    private Date updateDatetime ;

    public User(){
    }

    public User(String email, String password, String username, int clientType, Date updateDatetime) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.clientType = clientType;
        this.updateDatetime = updateDatetime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass()!= User.class){
            return false;
        }
        User le=(User)obj;
        if (le.email.equals(this.email)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.email + "\t" + this.username;
    }
}

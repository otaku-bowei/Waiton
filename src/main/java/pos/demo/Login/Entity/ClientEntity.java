package pos.demo.Login.Entity;

public class ClientEntity {
    private String email;
    private String password;
    private String username;

    public ClientEntity(){
    }

    public ClientEntity(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass()!= ClientEntity.class){
            return false;
        }
        ClientEntity le=(ClientEntity)obj;
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

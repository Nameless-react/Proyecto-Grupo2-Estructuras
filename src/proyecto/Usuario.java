
package proyecto;

public class Usuario {
    private String username;
    private String password;
    private boolean state;
    
    

    public Usuario(String username, String password, boolean state) {
        this.username = username;
        this.password = password;
        this.state = state;
    }
    
    public Usuario(){}
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    
           
}

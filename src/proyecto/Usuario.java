
package proyecto;

public class Usuario extends Persona {
    private String username;
    private String password;
    private boolean state;
    
    

    public Usuario(String name, String firstSurName, String secondSurName, long identification, String username, String password, boolean state) {
        super(name, firstSurName, secondSurName, identification);
        this.password = password;
        this.state = state;
    }
    
    
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

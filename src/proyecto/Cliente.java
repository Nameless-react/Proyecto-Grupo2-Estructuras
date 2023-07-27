/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author joel
 */
public class Cliente extends Persona {
    
    private String username;
    private String password;
    private boolean state;
    private String phone;
    
    public Cliente(String name, String firstSurName, String secondSurName, long identification, String username, String password, boolean state, String phone) {
        super(name, firstSurName, secondSurName, identification);
        this.password = password;
        this.phone = phone;
        this.state = state;
        this.username = username;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author joel
 */
public abstract class Persona {
    private String name;
    private String firstSurName;
    private String secondSurName;
    private long identification;
    
    public Persona(String name, String firstSurName, String secondSurName, long identification) {
        this.name = name;
        this.firstSurName = firstSurName;
        this.secondSurName = secondSurName;
        this.identification = identification;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurName() {
        return firstSurName;
    }

    public void setFirstSurName(String firstSurName) {
        this.firstSurName = firstSurName;
    }

    public String getSecondSurName() {
        return secondSurName;
    }

    public void setSecondSurName(String secondSurName) {
        this.secondSurName = secondSurName;
    }

    public long getIdentification() {
        return identification;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.firstSurName + " " + this.secondSurName;
    }
}

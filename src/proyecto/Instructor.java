/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author joel
 */
public class Instructor extends Persona {
    private long salary;
    private int experience;
    private String speciality;
    private boolean availability;
    
    
    public Instructor(String name, String firstSurName, String secondSurName, long identification, long salary, int experience, String speciality, boolean availability) {
        super(name, firstSurName, secondSurName, identification);
        this.salary = salary;
        this.experience = experience;
        this.speciality = speciality;
        this.availability = availability;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

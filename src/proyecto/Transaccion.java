/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author joel
 */
public class Transaccion {
    private static int globalId = 0;
    private int id;
    private LocalDateTime date;
    private double price;
    private Cliente student;
    private String concept;
    private String courses;

    
    public Transaccion(Cliente student, double price, LocalDateTime date, String concept, String courses) {
        this.id = ++globalId;
        this.student = student;
        this.price = price;
        this.date = date;
        this.concept = concept;
        this.courses = courses;
    }

    public Transaccion() {
    }
    
    

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cliente getStudent() {
        return student;
    }

    public void setStudent(Cliente student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }
    
    @Override
    public String toString() {
        return "Transacción Número: " + String.valueOf(this.id) + "\n"
                + "================"
        + "\nIdentificación: " + this.student.getIdentification()
        + "\nNombre: " + String.valueOf(this.student)
        + "\nFecha: " + this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        + "\nTeléfono: " + this.student.getPhone()
        + "\nCursos:\n" + this.courses
        + "\nConcepto: " + this.concept
        + "\n---------------------"
        + "\nMonto Total: " + String.valueOf(this.price);
    }
    
    
}

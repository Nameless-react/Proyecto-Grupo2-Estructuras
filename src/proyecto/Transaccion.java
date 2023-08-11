/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.time.LocalDateTime;

/**
 *
 * @author joel
 */
public class Transaccion {
    private LocalDateTime date;
    private double price;
    private Cliente student;

    
    public Transaccion(Cliente student, double price, LocalDateTime date) {
        this.student = student;
        this.price = price;
        this.date = date;
    }
    public void register() {
        
    }
    
    public void cancel() {
        
    }
    
    public void pay() {
        
    }
    
    public void cancelPay() {
        
    }
    
    public String showInvoice() {
        String invoice = "";
        
        
        
        return invoice;
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
}

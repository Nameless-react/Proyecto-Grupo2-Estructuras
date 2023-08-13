/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Horario;

/**
 *
 * @author joel
 */
public class NodoSCHorarios {
    private Horario data;
    private NodoSCHorarios next;
    
    public NodoSCHorarios() {
        this.next = null;
    }
    
    public NodoSCHorarios(Horario data) {
        this.next = null;
        this.data = data;
    }

    public Horario getData() {
        return data;
    }

    public void setData(Horario data) {
        this.data = data;
    }

    public NodoSCHorarios getNext() {
        return next;
    }

    public void setNext(NodoSCHorarios next) {
        this.next = next;
    }
}

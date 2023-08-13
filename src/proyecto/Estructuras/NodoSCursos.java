/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Curso;

/**
 *
 * @author joel
 */
public class NodoSCursos {
    private Curso data;
    private NodoSCursos next;

    public NodoSCursos() {
        this.next = null;
    }
    
    public NodoSCursos(Curso data) {
        this.next = null;
        this.data = data;
    }

    public Curso getData() {
        return this.data;
    }

    public void setData(Curso data) {
        this.data = data;
    }

    public NodoSCursos getNext() {
        return this.next;
    }

    public void setNext(NodoSCursos next) {
        this.next = next;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Instructor;

/**
 *
 * @author joel
 */
public class NodoDCInstructor {
    private Instructor data;
    private NodoDCInstructor next;
    private NodoDCInstructor previous;

    public NodoDCInstructor() {
        this.next = null;
        this.previous = null;
    }
    
    public NodoDCInstructor(Instructor data) {
        this.next = null;
        this.previous = null;
        this.data = data;
    }

    public Instructor getData() {
        return this.data;
    }

    public void setData(Instructor data) {
        this.data = data;
    }

    public NodoDCInstructor getNext() {
        return this.next;
    }

    public void setNext(NodoDCInstructor next) {
        this.next = next;
    }

    public NodoDCInstructor getPrevious() {
        return this.previous;
    }

    public void setPrevious(NodoDCInstructor previous) {
        this.previous = previous;
    }
}

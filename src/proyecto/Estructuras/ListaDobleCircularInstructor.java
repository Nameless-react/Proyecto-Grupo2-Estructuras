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
public class ListaDobleCircularInstructor {
    
    private NodoDCInstructor pointer;
    private NodoDCInstructor last;

    public ListaDobleCircularInstructor() {
        this.pointer = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.pointer == null;
    }

    public void add(Instructor instructor) {
        NodoDCInstructor newNode = new NodoDCInstructor(instructor);
        if (this.isEmpty()) {
            this.pointer = newNode;
            this.last = newNode;
            this.last.setNext(this.pointer);
            this.pointer.setPrevious(this.last);
        } else if (instructor.getSalary() < this.pointer.getData().getSalary()) {
            newNode.setNext(this.pointer);
            this.pointer = newNode;
            this.last.setNext(this.pointer);
            this.pointer.setPrevious(this.last);
        } else if (instructor.getSalary() >= this.last.getData().getSalary()) {
            this.last.setNext(newNode);
            this.last = newNode;
            this.last.setNext(this.pointer);
            this.pointer.setPrevious(this.last);
        } else {
            NodoDCInstructor current = this.pointer;
            while (current.getNext().getData().getSalary() < instructor.getSalary()) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            current.setNext(newNode);
            newNode.getNext().setPrevious(newNode);
        }
    }
    
    public Instructor find(long identification) {
        
        
        
        return null;
    }
    
    
    @Override
    public String toString() {
        NodoDCInstructor current = this.pointer;
        if (this.pointer == null) return "[]";

        String data = "[" + String.valueOf(current.getData());
        if (current.getNext() == null) return data + "]";
        current = current.getNext();
        while (current != this.pointer) {
            data += ", " + String.valueOf(current.getData());
            current = current.getNext();
        }
        return data + "]";
    }
}

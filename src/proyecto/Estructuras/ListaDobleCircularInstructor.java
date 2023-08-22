/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Cliente;
import proyecto.Handler;
import proyecto.Instructor;
import proyecto.RegistroCurso;

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
        if (this.find(instructor.getIdentification()) != null) {
            Handler.showMessage("La identificación ya está asignada a otro instructor", "Identficación repetida", Handler.ERROR);
            return;
        }
        
        Handler.showMessage("El instructor fue agregado exitosamente", "Éxito", Handler.INFORMATION);
        
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
    
    public void toggleState() {
        NodoDCInstructor current = this.pointer;

        long id = Handler.inputLong("Digite la identificación del usuario que quiere desactviar o activar");
        if (RegistroCurso.cursos.existInstructorInCourse(id)) {
            Handler.showMessage("No se puede desactivar el instructor ya que está a cargo de un curso", "Erorr al desactivar instructor", Handler.ERROR);
            return;
        }
        
        
        if (id == current.getData().getIdentification()) {
            Instructor instructor = current.getData();
            instructor.setAvailability(!instructor.isAvailability());
            Handler.showMessage("El instructor ha sido " + (instructor.isAvailability() ? "activado" : "desactivado"), "Instructor: " + instructor.getIdentification(), Handler.INFORMATION);
            return;
        }
        
        
        while (current != this.pointer) {
            Instructor instructor = current.getData();
            if (id == instructor.getIdentification()) {
                instructor.setAvailability(!instructor.isAvailability());
                Handler.showMessage("El instructor ha sido " + (instructor.isAvailability() ? "activado" : "desactivado"), "Instructor: " + instructor.getIdentification(), Handler.INFORMATION);
            }

            current = current.getNext();
        }

        Handler.showMessage("El instructor no existe", "Error: no encontrado", Handler.ERROR);
        char addMore = Handler.inputChar("Desea desactivar o activar otro instructor(s/n)");
        if (addMore == 'n') return;
        this.toggleState();
    }
    
    
    public Instructor find(long identification) {
        NodoDCInstructor current = this.pointer;
        if (current == null) return null;
        
        if (current.getData().getIdentification() == identification) return current.getData();
        current = current.getNext();
        
        
        while (current != this.pointer) {
            Instructor instructor = current.getData();
            if (identification == instructor.getIdentification() && instructor.isAvailability()) return instructor;
            current = current.getNext();
        }
        
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

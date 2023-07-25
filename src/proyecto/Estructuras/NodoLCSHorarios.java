
package proyecto.Estructuras;

import proyecto.Curso;

public class NodoLCSHorarios {
    private Curso elemento;
    private NodoLCSHorarios siguiente;

    public NodoLCSHorarios() {
        this.siguiente = null;
    }

    public Curso getData() {
        return elemento;
    }

    public void setData(Curso elemento) {
        this.elemento = elemento;
    }

    public NodoLCSHorarios getNext() {
        return siguiente;
    }

    public void setNext(NodoLCSHorarios siguiente) {
        this.siguiente = siguiente;
    }
}



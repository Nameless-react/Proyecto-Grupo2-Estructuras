
package proyecto.Estructuras;

import proyecto.Cajas;

public class NodoLSCajas {
    private NodoLSCajas next;
    private Cajas data;
    
    public NodoLSCajas(){
        
    }

    public NodoLSCajas(NodoLSCajas next) {
        this.next = next;
    }

    public NodoLSCajas getNext() {
        return next;
    }

    public void setNext(NodoLSCajas next) {
        this.next = next;
    }

    public Cajas getData() {
        return data;
    }

    public void setData(Cajas data) {
        this.data = data;
    }
    
    
}

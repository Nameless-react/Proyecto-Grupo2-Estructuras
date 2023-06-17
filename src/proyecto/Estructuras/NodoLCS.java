
package proyecto.Estructuras;

import proyecto.Usuario;

public class NodoLCS {
    private Usuario data;
    private NodoLCS next;
    
    public NodoLCS(NodoLCS next){
        this.next = next;
    }

    public NodoLCS() {
    }
    

    public Usuario getData() {
        return data;
    }

    public void setData(Usuario data) {
        this.data = data;
    }

    public NodoLCS getNext() {
        return next;
    }

    public void setNext(NodoLCS next) {
        this.next = next;
    }
    
    
}




package proyecto.Estructuras;

import proyecto.Usuario;

public class NodoLCS {
    private Usuario data;
    private NodoLCS next;
    
    public NodoLCS(Usuario user) {
        this.data = user;
    }

    public NodoLCS() {}
    
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



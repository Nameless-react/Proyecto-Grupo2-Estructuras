
package proyecto.Estructuras;

import proyecto.Usuario;

public class NodoLSUsuarios {
    private Usuario data;
    private NodoLSUsuarios next;
    
    public NodoLSUsuarios(Usuario user) {
        this.data = user;
    }

    public NodoLSUsuarios() {}
    
    public Usuario getData() {
        return data;
    }

    public void setData(Usuario data) {
        this.data = data;
    }

    public NodoLSUsuarios getNext() {
        return next;
    }

    public void setNext(NodoLSUsuarios next) {
        this.next = next;
    }
}



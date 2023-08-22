
package proyecto.Estructuras;

import java.time.LocalDateTime;
import proyecto.Cajas;
import proyecto.RegistroTransacciones;
import proyecto.Transaccion;

public class ListaSimpleCajas {
    
    private NodoLSCajas cabeza;
    private NodoLSCajas fin;
    
    public ListaSimpleCajas(){
        this.cabeza = null;
        this.fin = null;
        
    }
    
    public boolean isEmpty(){
        return this.cabeza == null;
    }
    
    public void push(LocalDateTime date){
        Cajas cajas = new Cajas();
        NodoLSCajas aux = new NodoLSCajas();
        
        cajas.setIngresos(RegistroTransacciones.transactions.earnings(date));
        cajas.setFecha(date);
        
        aux.setData(cajas);
        
        if (this.isEmpty()) {
            this.cabeza = aux;
            this.fin = aux;
            this.fin.setNext(cabeza);
        } else if (cajas.getIngresos()<cabeza.getData().getIngresos()) {
            aux.setNext(this.cabeza);
            this.cabeza = aux;
            this.fin.setNext(this.cabeza);
        } else if (this.cabeza.getNext() == null) {
            this.fin.setNext(aux);
            this.fin = aux;
            this.fin.setNext(this.cabeza);
        } else {
            NodoLSCajas aux2 = this.cabeza;
            while ((aux2.getNext() != null)
                    && (aux2.getNext().getData().getIngresos()<cajas.getIngresos())) {
                aux2 = aux2.getNext();
            }
            aux.setNext(aux2.getNext());
            aux2.setNext(aux);
        }
        
    }
}

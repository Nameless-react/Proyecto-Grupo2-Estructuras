
package proyecto.Estructuras;

import java.time.LocalDateTime;
import proyecto.Cajas;
import proyecto.Cliente;
import proyecto.RegistroTransacciones;

public class ListaSimpleCajas {
    
    private NodoLSCajas cabeza;
    private NodoLSCajas fin;
    private Cliente[] clientes = new Cliente[1];
    
    public ListaSimpleCajas(){
        this.cabeza = null;
        this.fin = null;
        
    }
    
    public boolean isEmpty(){
        return this.cabeza == null;
    }
    
    public void push(LocalDateTime date, double money){
        Cajas cajas = new Cajas();
        NodoLSCajas aux = new NodoLSCajas();
        
        cajas.setIngresos(money);
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
    
    public void addClient(Cliente client) {
        if (this.clientes[0] == null) {
            this.clientes[0] = client;
            return;
        }
        
        Cliente[] tempClientes = new Cliente[this.clientes.length + 1];
        System.arraycopy(this.clientes, 0, tempClientes, 0, this.clientes.length);
        tempClientes[tempClientes.length - 1] = client;
        this.clientes = tempClientes;
    }
    
    public String showClient() {
        String data = "";
        
        for (Cliente client : this.clientes) {
            if (client == null) continue;
            
            data += client.toString() + "\n";
        }
        
        return data;
    }
}

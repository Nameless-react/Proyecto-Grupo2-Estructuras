/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Cliente;

/**
 *
 * @author joel
 */
public class NodoLSClientes {
     private Cliente data;
    private NodoLSClientes next;

    public NodoLSClientes() {
        this.next = null;
    }
    
    public NodoLSClientes(Cliente data) {
        this.data = data;
        this.next = null;
    }

    
    public boolean hasNext() {
        return this.next != null;
    }
    
    public Cliente getData() {
        return data;
    }

    public void setData(Cliente data) {
        this.data = data;
    }

    public NodoLSClientes getNext() {
        return next;
    }

    public void setNext(NodoLSClientes next) {
        this.next = next;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Cliente;
import proyecto.Handler;

/**
 *
 * @author joel
 */
public class ListaSimpleCliente {

    private NodoLSClientes pointer;

    public ListaSimpleCliente() {
        this.pointer = null;
    }

    public boolean isEmpty() {
        return this.pointer == null;
    }

    public void add(Cliente client) {
        NodoLSClientes newNode = new NodoLSClientes(client);

        if (this.isEmpty()) {
            this.pointer = newNode;
            Handler.showMessage("Cliente agregado exitosamente", "Cliente agregado", Handler.INFORMATION);
            return;
        }

        NodoLSClientes current = this.pointer;
        while (current.hasNext()) {
            if (current.getData().getIdentification() == client.getIdentification()) {
                Handler.showMessage("El cliente ya existe", "Cliente repetido", Handler.ERROR);
                return;
            }
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        Handler.showMessage("Cliente agregado exitosamente", "Cliente agregado", Handler.INFORMATION);
    }

    public void deleteFirst() {
        if (!this.isEmpty()) {
            this.pointer = this.pointer.getNext();
        }
    }

    public Cliente find(long id) {
        Cliente client = null;
        
        NodoLSClientes current = this.pointer;
        while (current != null) { 
            if (current.getData().getIdentification() == id && current.getData().isState()) client = current.getData();
            current = current.getNext();
        }
        
        return client;
    }
    
    public void toggleState() {
        NodoLSClientes current = this.pointer;

        long id = Handler.inputLong("Digite la identificación del usuario que quiere desactviar o activar");

        //Verificar que no tenga relación con otros catálogos
        while (current.hasNext()) {
            Cliente client = current.getData();
            if (id == client.getIdentification()) {
                client.setState(!client.isState());
                Handler.showMessage("El clinete ha sido " + (client.isState() ? "activado" : "desactivado"), "Usuario: " + client.getIdentification(), Handler.INFORMATION);
            }

            current = current.getNext();
        }

        Handler.showMessage("El usuario no existe", "Error: no encontrado", Handler.ERROR);
        char addMore = Handler.inputChar("Desea desactivar o activar otro cliente (s/n)");
        if (addMore == 'n') {
            return;
        }
        this.toggleState();
    }

    @Override
    public String toString() {
        NodoLSClientes current = this.pointer;
        if (this.pointer == null) return "[]";

        String data = "[" + String.valueOf(current.getData());
        if (current.getNext() == null) return data + "]";
        current = current.getNext();
        while (current != null) {
            data += ", " + String.valueOf(current.getData());
            current = current.getNext();
        }
        return data + "]";
    }
}

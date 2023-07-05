/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Handler;
import proyecto.Usuario;

/**
 *
 * @author joel
 */
public class ListaSimple {
    public NodoLCS pointer;
    public NodoLCS last;
    public int size;
    
    public ListaSimple() {
        this.pointer = null;
        this.size = 0;
        this.last = null;
    }
    
    public boolean isEmpty(){
        return pointer == null;
    }
    
    public int size() {
        return this.size;
    }
    
    public void push(Usuario user){
        NodoLCS newNode = new NodoLCS(user);
        this.size++;
        
        if (this.isEmpty()){
            this.pointer = newNode;
            this.last = newNode;
            return;
        }
        newNode.setNext(this.pointer);
        this.last.setNext(newNode);
        Handler.showMessage("El usuario fue creaodo exitosamente", "Usuario creado", Handler.INFORMATION);   
    }

    public Usuario find(long id) {
        NodoLCS current = this.pointer;
        Usuario user = null;
        
        while(current != this.last) {
            if (id == current.getData().getIdentification()) user = current.getData();
            current = current.getNext();
        }
        
        return user;
    }
    
    public void update(Usuario user) {
        NodoLCS current = this.pointer;
        
        
        while (current != this.last) {
            if (user.getIdentification() == current.getData().getIdentification()) {
                current.setData(user);
                Handler.showMessage("Usuario actualizado correctamente", "Actualizado", Handler.INFORMATION);
                return;
            } 
            current = current.getNext();
        }
        
        Handler.showMessage("El usuario no existe", "Error: no encontrado", Handler.ERROR);
    }
    
    
    @Override
    public String toString() {
        if (this.pointer == null) return "[]";

        String data = "[" + String.valueOf(this.pointer.getData());
        NodoLCS current = this.pointer.getNext();

        while (current != this.pointer) {
            data += ", " + String.valueOf(current.getData());
            current = current.getNext();
        }
        return data + "]";
    }
}

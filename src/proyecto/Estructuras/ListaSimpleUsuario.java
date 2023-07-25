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
public class ListaSimpleUsuario {
    public NodoLCS pointer;
    public int size;
    
    public ListaSimpleUsuario() {
        this.pointer = new NodoLCS();
        this.pointer.setNext(this.pointer);
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return this.pointer == null;
    }
    
    public int size() {
        return this.size;
    }
    
    public void push(Usuario user){
        NodoLCS newNode = new NodoLCS(user);
        NodoLCS current = this.pointer;
        
        if (this.size == 0){
            this.pointer.setData(user);
            Handler.showMessage("El usuario fue creado exitosamente", "Usuario creado", Handler.INFORMATION);   
            this.size++;
            return;
        }
        
        while (current.getNext() != this.pointer) {
            current = current.getNext();
        }
        
        current.setNext(newNode);
        newNode.setNext(this.pointer);
        this.size++;
        
        Handler.showMessage("El usuario fue creado exitosamente", "Usuario creado", Handler.INFORMATION);   
    }

    
    public Usuario find(long id) {
        NodoLCS current = this.pointer;
        Usuario user = null;
        
        while(current.getNext() != this.pointer) {
            if (id == current.getData().getIdentification()) user = current.getData();
            current = current.getNext();
        }
        
        return user;
    }
    
    public void update(Usuario user) {
        NodoLCS current = this.pointer;
        
        
        while (current.getNext() != this.pointer) {
            if (user.getIdentification() == current.getData().getIdentification()) {
                current.setData(user);
                Handler.showMessage("Usuario actualizado correctamente", "Actualizado", Handler.INFORMATION);
                return;
            } 
            current = current.getNext();
        }
        
        Handler.showMessage("El usuario no existe", "Error: no encontrado", Handler.ERROR);
    }
    
    public void toggleState(long id) {
        NodoLCS current = this.pointer;
        
        
        while (current != this.pointer) {
            Usuario user = current.getData();
            if (id == user.getIdentification()) {
                user.setState(!user.getState());
                Handler.showMessage("El usuario ha sido " + (user.getState() ? "activado" : "desactivado"), "Usuario: " + user.getIdentification(), Handler.INFORMATION);
                return;
            }
            
            current = current.getNext();
        }
        
        Handler.showMessage("El usuario no existe", "Error: no encontrado", Handler.ERROR);
    }
    
    @Override
    public String toString() {
        NodoLCS current = this.pointer;
        if (current == null) return "[]";

        String data = "[" + String.valueOf(current.getData());
        current = current.getNext();
        
        while (current != this.pointer) {
            data += ", " + String.valueOf(current.getData());
            current = current.getNext();
        }
        return data + "]";
    }
}

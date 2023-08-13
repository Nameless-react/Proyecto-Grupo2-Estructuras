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
    public NodoLSUsuarios pointer;
    public int size;
    
    public ListaSimpleUsuario() {
        this.pointer = new NodoLSUsuarios();
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
        NodoLSUsuarios newNode = new NodoLSUsuarios(user);
        NodoLSUsuarios current = this.pointer;
        
        if (this.find(user.getIdentification()) != null) {
            Handler.showMessage("La identificación del usuario ya está asiganda", "Identificación ya existente", Handler.ERROR);
            return;
        }
        
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
        NodoLSUsuarios current = this.pointer;
        Usuario user = null;
        if (this.pointer.getData().getIdentification() == id) return this.pointer.getData();
        current = current.getNext();
        
        while(current != this.pointer) {
            if (id == current.getData().getIdentification()) return current.getData();
            current = current.getNext();
        }
        
        return null;
    }
    
    public void update(Usuario user) {
        NodoLSUsuarios current = this.pointer;
        
        if (user.getIdentification() == current.getData().getIdentification()) {
            current.setData(user);
            Handler.showMessage("Usuario actualizado correctamente", "Actualizado", Handler.INFORMATION);
            return;
        } 
        
        current = current.getNext();
        while (current != this.pointer) {
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
        NodoLSUsuarios current = this.pointer;
        
        //Verificar que no tenga relación con otros catálogos
        if (id == current.getData().getIdentification()) {
            current.getData().setState(!current.getData().getState());
            Handler.showMessage("El usuario ha sido " + (current.getData().getState() ? "activado" : "desactivado"), "Usuario: " + current.getData().getIdentification(), Handler.INFORMATION);
            return;
        }
        
        current = current.getNext();
        
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
        NodoLSUsuarios current = this.pointer;
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

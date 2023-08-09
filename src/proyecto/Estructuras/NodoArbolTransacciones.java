/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Transaccion;

/**
 *
 * @author joel
 */
public class NodoArbolTransacciones {
    private Transaccion data;
    private NodoArbolTransacciones left;
    private NodoArbolTransacciones right;

    public NodoArbolTransacciones() {
        this.left = null;
        this.right = null;
    }

    public Transaccion getData() {
        return this.data;
    }

    public void setData(Transaccion data) {
        this.data = data;
    }

    public NodoArbolTransacciones getLeft() {
        return this.left;
    }

    public void setLeft(NodoArbolTransacciones left) {
        this.left = left;
    }

    public NodoArbolTransacciones getRight() {
        return this.right;
    }

    public void setRight(NodoArbolTransacciones right) {
        this.right = right;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

/**
 *
 * @author joel
 */
public class OpcionMenu {
    private int numero;
    private String descripcion;

    public OpcionMenu(int numero, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return numero + ". " + descripcion;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import javax.swing.JOptionPane;
import proyecto.Curso;

/**
 *
 * @author joel
 */
public class ListaSimpleCursos {
    private NodoSCursos inicio;

    public ListaSimpleCursos() {
        this.inicio = null;
    }
    
    public boolean isEmpty() {
        return this.inicio == null;
    }
    public void add(Curso curso){
        
        NodoSCursos nuevo = new NodoSCursos(curso);
        if (this.isEmpty()) {
            this.inicio=nuevo;
        }else if(curso.getNombre().compareToIgnoreCase(this.inicio.getData().getNombre())<0){
            nuevo.setNext(this.inicio);
            this.inicio=nuevo;
        }else if(this.inicio.getNext()==null){
            this.inicio.setNext(nuevo);
        }else{
            NodoSCursos aux = this.inicio;
            while((aux.getNext() != null)&&(aux.getNext().getData().getNombre().compareToIgnoreCase(curso.getNombre())<0)){
                aux = aux.getNext();
            }
            nuevo.setNext(aux.getNext());
            aux.setNext(nuevo);
        }
    }
   
    
    public void remove(){
        if (!this.isEmpty()) {
            String nombre=JOptionPane.showInputDialog("Escriba el Nombre del Data que se quiere Eliminar: ");
            if (this.inicio.getData().getNombre().equals(nombre)) {
                this.inicio=this.inicio.getNext();
            }else{
                NodoSCursos anterior;
                NodoSCursos auxiliar;
                anterior=this.inicio;
                auxiliar=this.inicio.getNext();
                while((auxiliar!=null)&&(!auxiliar.getData().getNombre().equals(nombre))){
                    anterior=anterior.getNext();
                    auxiliar=auxiliar.getNext();
                }
                if (auxiliar!=null) {
                    anterior.setNext(auxiliar.getNext());
                }
            }
            JOptionPane.showMessageDialog(null, "¡EL Data FUE EXTRAIDO!");
        }else{
            JOptionPane.showMessageDialog(null, "¡NO SE PUEDE EXTRAER, LISTA VACIA!");
        }
    }
    
    public void show(){
        if (!this.isEmpty()) {
            String s="";
            NodoSCursos aux=this.inicio;
            while(aux!=null){
                s=s+aux.getData().getCodigo()+"--"+aux.getData().getNombre()+"--"+aux.getData().getHorario()+"<--";
                aux=aux.getNext();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene:\n"+s);
        }else{
            JOptionPane.showMessageDialog(null, "¡NO SE PUEDE MOSTRAR, LISTA VACIA!");
        }
    }
}

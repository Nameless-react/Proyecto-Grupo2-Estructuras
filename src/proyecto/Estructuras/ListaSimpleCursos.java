/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import javax.swing.JOptionPane;
import proyecto.Curso;
import proyecto.Handler;
import proyecto.RegistroInstructor;

/**
 *
 * @author joel
 */
public class ListaSimpleCursos {
    private NodoSCursos inicio;
    private int size;

    public ListaSimpleCursos() {
        this.inicio = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.inicio == null;
    }
    public void add(Curso curso){
        this.size++;
        NodoSCursos nuevo = new NodoSCursos(curso);
        Handler.showMessage("El curso fue agregado exitosamente", "Existo", Handler.INFORMATION);
        if (this.find(curso.getCodigo()) != null) {
            Handler.showMessage("El curso con el código " + curso.getCodigo() + " ya existe", "Error al guardar el curso", Handler.ERROR);
            return;
        }
        
        
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
            String codigo = JOptionPane.showInputDialog("Escriba el código del curso que se quiere eliminar: ");
            
            if (this.inicio.getData().getCodigo().equals(codigo)) {
                
                this.inicio=this.inicio.getNext();
            }else{
                NodoSCursos anterior;
                NodoSCursos auxiliar;
                anterior=this.inicio;
                auxiliar=this.inicio.getNext();
                while((auxiliar!=null)&&(!auxiliar.getData().getNombre().equals(codigo))){
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
    
    public Curso[] fillComboBox() {
        Curso[] cursos = new Curso[this.size];
        NodoSCursos current = this.inicio;
        int counter = 0;
        
        while (current != null) {
            if (current.getData().isActivo()) {
                cursos[counter] = current.getData();
            }
            counter++;
            current = current.getNext();
        }
        
        return cursos;
    }
    
    
    public Curso find(String code) {
        Curso course = null;
        NodoSCursos current = this.inicio;
        
        while (current != null) {
            if (current.getData().getCodigo().equals(code)) return current.getData();
            current = current.getNext();
            
        }
        
        return course;
    }
    
    public boolean existInstructorInCourse(long id) {
        NodoSCursos current = this.inicio;
        
        while (current != null) {
            if (current.getData().getInstructor().getIdentification() == id) return true;
        }
        return false;
    }
    
    public void toggleState(String codigo) {
        NodoSCursos current = this.inicio;
        
        while (current != null) {
            if (codigo.equals(current.getData().getCodigo())) {
                current.getData().setActivo(!current.getData().isActivo());
                Handler.showMessage("El curso ha sido " + (current.getData().isActivo() ? "activado" : "desactivado"), "Curso: " + current.getData().getCodigo(), Handler.INFORMATION);
                return;
            }
            current = current.getNext();
        }
        
        Handler.showMessage("No se pudo cambiar desactivar/activar", "Error al cambiar estado", Handler.ERROR);
    }
}

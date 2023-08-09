/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import proyecto.Curso;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class ListaSimpleHorario {
    OpcionMenu[] horarios = {
        new OpcionMenu(1, "8am-11am"),
        new OpcionMenu(2, "11am-2pm"),
        new OpcionMenu(3, "2pm-5pm"),
        new OpcionMenu(4, "6pm-9pm")
        };
    
    private NodoLCSHorarios inicio;

    public ListaSimpleHorario() {
        this.inicio = null;
    }
    
    public boolean esVacia() {
        return this.inicio == null;
    }
    
    public void agregar(){
        Curso c = new Curso();
        c.setNombre(JOptionPane.showInputDialog("Escriba el nombre del curso: "));
        c.setCodigo(JOptionPane.showInputDialog("Digite el codigo del curso: "));
        
        OpcionMenu opcionSeleccionada = (OpcionMenu) JOptionPane.showInputDialog(
                null,
                "Horarios",
                "Elija el horario en el cual le gustaria llevar el curso",
                JOptionPane.QUESTION_MESSAGE,
                null,
                horarios,
                horarios[0]
        );
        
        if (opcionSeleccionada != null) {
            int opcion = opcionSeleccionada.getNumero();

            switch (opcion) {
                case 1:
                    c.setHorario("8am-11am");
                    break;
                case 2:
                    c.setHorario("11am-2pm");
                    break;
                case 3:
                    c.setHorario("2pm-5pm");
                    break;
                case 4:
                    c.setHorario("6pm-9pm");
                    break;
            }
        }
        NodoLCSHorarios nuevo = new NodoLCSHorarios();
        nuevo.setData(c);
        if (esVacia()) {
            inicio=nuevo;
        }else if(c.getNombre().compareToIgnoreCase(inicio.getData().getNombre())<0){
            nuevo.setNext(inicio);
            inicio=nuevo;
        }else if(inicio.getNext()==null){
            inicio.setNext(nuevo);
        }else{
            NodoLCSHorarios aux = inicio;
            while((aux.getNext() != null)&&(aux.getNext().getData().getNombre().compareToIgnoreCase(c.getNombre())<0)){
                aux = aux.getNext();
            }
            nuevo.setNext(aux.getNext());
            aux.setNext(nuevo);
        }
    }
    
    public void eliminarAlInicio(){
        if (!esVacia()) {
            inicio=inicio.getNext();
            JOptionPane.showMessageDialog(null, "¡EL ELEMENTO FUE EXTRAIDO!");
        }else{
            JOptionPane.showMessageDialog(null, "¡NO SE PUEDE EXTRAER, LISTA VACIA!");
        }
    }
    
    public void eliminarEspecifico(){
        if (!esVacia()) {
            String nombre=JOptionPane.showInputDialog("Escriba el Nombre del Elemento que se quiere Eliminar: ");
            if (inicio.getData().getNombre().equals(nombre)) {
                inicio=inicio.getNext();
            }else{
                NodoLCSHorarios anterior;
                NodoLCSHorarios auxiliar;
                anterior=inicio;
                auxiliar=inicio.getNext();
                while((auxiliar!=null)&&(!auxiliar.getData().getNombre().equals(nombre))){
                    anterior=anterior.getNext();
                    auxiliar=auxiliar.getNext();
                }
                if (auxiliar!=null) {
                    anterior.setNext(auxiliar.getNext());
                }
            }
            JOptionPane.showMessageDialog(null, "¡EL ELEMENTO FUE EXTRAIDO!");
        }else{
            JOptionPane.showMessageDialog(null, "¡NO SE PUEDE EXTRAER, LISTA VACIA!");
        }
    }
    
    public void mostrarElemento(){
        if (!esVacia()) {
            String s="";
            NodoLCSHorarios aux=inicio;
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

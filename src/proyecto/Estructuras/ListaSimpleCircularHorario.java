/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import proyecto.Handler;
import proyecto.Horario;

/**
 *
 * @author joel
 */
public class ListaSimpleCircularHorario {

    private NodoSCHorarios inicio;
    private NodoSCHorarios fin;

    private static String rutaArchivo = "horarios.txt";

    public ListaSimpleCircularHorario() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void add() {
        Horario horario = new Horario();
        horario.setHoraInicio(JOptionPane.showInputDialog("Escriba la hora de inicio: "));
        horario.setHoraFinal(JOptionPane.showInputDialog("Escriba la hora de finalizacion: "));
        NodoSCHorarios nuevo = new NodoSCHorarios();

        nuevo.setData(horario);
        if (this.isEmpty()) {
            this.inicio = nuevo;
            this.fin = nuevo;
            this.fin.setNext(inicio);
        } else if (horario.getHoraInicio().compareTo(inicio.getData().getHoraInicio()) < 0) {
            nuevo.setNext(this.inicio);
            this.inicio = nuevo;
            this.fin.setNext(this.inicio);
        } else if (this.inicio.getNext() == null) {
            this.fin.setNext(nuevo);
            this.fin = nuevo;
            this.fin.setNext(this.inicio);
        } else {
            NodoSCHorarios aux = this.inicio;
            while ((aux.getNext() != null)
                    && (aux.getNext().getData().
                            getHoraInicio()).compareTo(horario.getHoraInicio()) < 0) {
                aux = aux.getNext();
            }
            nuevo.setNext(aux.getNext());
            aux.setNext(nuevo);
        }
    }

    public void add(Horario horario) {
        NodoSCHorarios nuevo = new NodoSCHorarios(horario);

        if (this.isEmpty()) {
            this.inicio = nuevo;
            this.fin = nuevo;
            this.fin.setNext(inicio);
        } else if (horario.getHoraInicio().compareTo(inicio.getData().getHoraInicio()) < 0) {
            nuevo.setNext(this.inicio);
            this.inicio = nuevo;
            this.fin.setNext(this.inicio);
        } else if (this.inicio.getNext() == null) {
            this.fin.setNext(nuevo);
            this.fin = nuevo;
            this.fin.setNext(this.inicio);
        } else {
            NodoSCHorarios aux = this.inicio;
            while ((aux.getNext() != null)
                    && (aux.getNext().getData().
                            getHoraInicio()).compareTo(horario.getHoraInicio()) < 0) {
                aux = aux.getNext();
            }
            nuevo.setNext(aux.getNext());
            aux.setNext(nuevo);
        }
    }

    public void remove() {
        if (!this.isEmpty()) {
            String horaInicio = JOptionPane.showInputDialog("Escriba la hora de inicio del horario que se quiere Eliminar: ");
            String horaFinal = JOptionPane.showInputDialog("Escriba la hora de finalizacion del horario que se quiere Eliminar: ");

            if (inicio.getData().getHoraInicio().equals(horaInicio) && inicio.getData().getHoraFinal().equals(horaFinal)) {
                this.inicio = this.inicio.getNext();
            } else {
                NodoSCHorarios anterior = this.inicio;
                NodoSCHorarios auxiliar = this.inicio.getNext();

                while ((auxiliar != null) && (!auxiliar.getData().getHoraInicio().equals(horaInicio) && !auxiliar.getData().getHoraFinal().equals(horaFinal))) {
                    anterior = anterior.getNext();
                    auxiliar = auxiliar.getNext();
                }

                if (auxiliar != null) {
                    anterior.setNext(auxiliar.getNext());
                }
            }

            JOptionPane.showMessageDialog(null, "¡EL ELEMENTO FUE ELIMINADO!");
        } else {
            JOptionPane.showMessageDialog(null, "¡NO SE PUEDE ELIMINAR, LA LISTA ESTÁ VACIA!");
        }
    }

    public String show() {
        if (!this.isEmpty()) {
            String s = "";
            NodoSCHorarios aux = this.inicio;
            s = s + aux.getData().getHoraInicio() + "/"
                    + aux.getData().getHoraFinal() + "-";
            aux = aux.getNext();
            while (aux != this.inicio) {
                s = s + aux.getData().getHoraInicio() + "/"
                        + aux.getData().getHoraFinal() + "-";
                aux = aux.getNext();
            }
            JOptionPane.showMessageDialog(null,
                    "La lista simple circular contiene:\n" + s);
            return s;
        } else {
            JOptionPane.showMessageDialog(null,
                    "¡No existen elementos para mostrar, lista vacía");
        }
        return null;
    }

    public void writeFile() {
        String texto = this.show();

        try {

            // Crea un objeto FileWriter y BufferedWriter para escribir en el archivo
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.rutaArchivo));

            // Escribe el texto en el archivo
            bufferedWriter.write(texto);

            // Cierra el BufferedWriter para asegurarte de que los datos se escriban en el archivo
            bufferedWriter.close();
        } catch (IOException e) {
            Handler.showMessage("No se pudo escribir en el archivo", "Error al escribir", Handler.ERROR);
        }
    }

    public void readFile() {
        String fileContent = "";

        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.rutaArchivo));
            while ((line = bufferedReader.readLine()) != null) {
                fileContent += line + "\n";

            }
            bufferedReader.close();

            String[] splitContent = fileContent.split("-");
            for (String schedule : splitContent) {
                try {
                    String[] scheduleSplit = schedule.split("/");
                    this.add(new Horario(scheduleSplit[0], scheduleSplit[1]));
                } catch (IndexOutOfBoundsException e) {
                    Handler.showMessage("Error en la conversión de datos", "Error", Handler.ERROR);
                }
            }
        } catch (IOException ex) {

            if (ex.getMessage().matches("[0-9A-Za-z]*\\.txt \\(No such file or directory\\)")) {

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(this.rutaArchivo));
                    writer.write("8:00/9:00"
                            + "-11:00/12:00"
                            + "-14:00/15:00"
                            + "-17:00/18:00");
                    writer.close();
                    
                    this.add(new Horario("8:00", "9:00"));
                    this.add(new Horario("11:00", "12:00"));
                    this.add(new Horario("14:00", "15:00"));
                    this.add(new Horario("17:00", "18:00"));
                    
                } catch (IOException ex1) {
                    Handler.showMessage("No se pudo leer el archivo", "Error al leer", Handler.ERROR);
                }
            }
        }
    }
}

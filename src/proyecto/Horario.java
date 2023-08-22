/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author joel
 */
public class Horario {

    private String horaInicio;
    private String horaFinal;
    private boolean activo;

    public Horario(String inicio, String fin, boolean activo) {
        this.horaInicio = inicio;
        this.horaFinal = fin;
        this.activo = activo;
    }
    
    public Horario() {}

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return this.horaInicio + "-" + this.horaFinal;
    }
}

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

    private String HoraInicio;
    private String HoraFinal;

    public Horario(String inicio, String fin) {
        this.HoraInicio = inicio;
        this.HoraFinal = fin;
    }
    
    public Horario() {}

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraFinal() {
        return HoraFinal;
    }

    public void setHoraFinal(String HoraFinal) {
        this.HoraFinal = HoraFinal;
    }
}

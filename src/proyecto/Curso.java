/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author joel
 */
public class Curso {
    private String codigo;
    private String nombre;
    private String horario;
    private Instructor instructor;
    private boolean activo;

    public Curso(String codigo, String nombre, String horario, Instructor instructor, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horario = horario;
        this.instructor = instructor;
        this.activo = activo;
    }
    
    public Curso() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return this.codigo + " " + this.nombre + " " + this.horario;
    }
    
    
}

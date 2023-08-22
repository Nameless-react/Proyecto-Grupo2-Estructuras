
package proyecto;

import java.time.LocalDateTime;

public class Cajas {
    private double ingresos;
    private LocalDateTime fecha;

    public Cajas(double ingresos, LocalDateTime fecha) {
        this.ingresos = ingresos;
        this.fecha = fecha;
    }

    public Cajas() {
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    
    
}

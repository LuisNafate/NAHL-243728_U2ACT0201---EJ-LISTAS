package ejercicio1;

public class Tarea {
    String descripcion;
    String prioridad;

    public Tarea(String descripcion, String prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getPrioridad() {
        return this.prioridad;
    }

    @Override
    public String toString() {
        return "Tarea: " + this.descripcion + " (Prioridad: " + this.prioridad + ")";
    }
}
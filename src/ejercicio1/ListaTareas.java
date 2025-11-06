package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class ListaTareas {
    private List<Tarea> tareas;

    public ListaTareas() {
        this.tareas = new ArrayList<>();
    }

    private int getValorPrioridad(String prioridad) {
        if (prioridad.equalsIgnoreCase("alta")) return 1;
        if (prioridad.equalsIgnoreCase("media")) return 2;
        return 3;
    }

    public void agregar(Tarea nuevaTarea) {
        int prioridadNueva = getValorPrioridad(nuevaTarea.getPrioridad());
        int posicionCorrecta = 0;

        for (Tarea tareaExistente : tareas) {
            if (prioridadNueva >= getValorPrioridad(tareaExistente.getPrioridad())) {
                posicionCorrecta++;
            } else {
                break;
            }
        }
        tareas.add(posicionCorrecta, nuevaTarea);
    }

    public void mostrar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
            return;
        }
        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
    }
}
package ejercicio1;

import ejercicio1.ListaTareas;
import ejercicio1.Tarea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaTareas miLista = new ListaTareas();

        while (true) {
            System.out.println("\n¿Qué quieres hacer?");
            System.out.println("1. Agregar una nueva tarea");
            System.out.println("2. Mostrar todas las tareas");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Escribe la descripción de la tarea: ");
                String descripcion = scanner.nextLine();

                System.out.print("Escribe la prioridad (alta, media, baja): ");
                String prioridad = scanner.nextLine();


                miLista.agregar(new Tarea(descripcion, prioridad));
                System.out.println("¡Tarea agregada!");

            } else if (opcion.equals("2")) {
                miLista.mostrar();

            } else if (opcion.equals("3")) {
                System.out.println("¡Adiós!");
                break; 

            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }
}
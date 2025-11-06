import ejercicio1.ListaTareas;
import ejercicio1.Tarea;
import ejercicio2.Cancion;
import ejercicio2.PlaylistCircular;
import ejercicio3.HistorialNavegacion;

import java.util.Scanner;

// Programa principal que maneja los 3 ejercicios
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("    SISTEMA DE GESTION DE LISTAS - JAVA     ");

        while (true) {
            System.out.println("\n============ MENU PRINCIPAL ============");
            System.out.println("1. Gestor de Tareas");
            System.out.println("2. Playlist Circular");
            System.out.println("3. Historial de Navegacion");
            System.out.println("0. Salir");
            System.out.println("========================================");
            System.out.print("Elige una opcion: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    ejecutarGestorTareas();
                    break;
                case 2:
                    ejecutarPlaylist();
                    break;
                case 3:
                    ejecutarHistorialNavegacion();
                    break;
                case 0:
                    System.out.println("\nProceso finalizado :)");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
        }
    }

    // Ejercicio 1 - Gestor de tareas con prioridades
    private static void ejecutarGestorTareas() {
        ListaTareas miLista = new ListaTareas();
        boolean continuar = true;

        System.out.println("\n=======================================");
        System.out.println("      GESTOR DE TAREAS                 ");
        System.out.println("=======================================");

        while (continuar) {
            System.out.println("\n--- Menu de Tareas ---");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Mostrar todas las tareas");
            System.out.println("3. Volver al menu principal");
            System.out.print("Elige una opcion: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    System.out.print("Descripcion de la tarea: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Prioridad (alta/media/baja): ");
                    String prioridad = scanner.nextLine();

                    miLista.agregar(new Tarea(descripcion, prioridad));
                    System.out.println("Tarea agregada exitosamente");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Tareas ---");
                    miLista.mostrar();
                    break;

                case 3:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    // Ejercicio 2 - Lista circular de canciones
    private static void ejecutarPlaylist() {
        PlaylistCircular playlist = new PlaylistCircular();
        boolean continuar = true;

        System.out.println("\n=======================================");
        System.out.println("      PLAYLIST CIRCULAR                ");
        System.out.println("=======================================");

        while (continuar) {
            System.out.println("\n--- Menu de Playlist ---");
            System.out.println("1. Agregar cancion");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Eliminar cancion actual");
            System.out.println("5. Mostrar cancion actual");
            System.out.println("6. Mostrar todas las canciones");
            System.out.println("7. Modo aleatorio sin repetir");
            System.out.println("8. Volver al menu principal");
            System.out.print("Elige una opcion: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    playlist.agregar(new Cancion(titulo, artista));
                    System.out.println("Cancion agregada correctamente");
                    break;

                case 2:
                    if (playlist.estaVacia()) {
                        System.out.println("La playlist esta vacia");
                    } else {
                        System.out.println("Reproduciendo siguiente: " + playlist.siguiente());
                    }
                    break;

                case 3:
                    if (playlist.estaVacia()) {
                        System.out.println("La playlist esta vacia");
                    } else {
                        System.out.println("Reproduciendo anterior: " + playlist.anterior());
                    }
                    break;

                case 4:
                    if (playlist.estaVacia()) {
                        System.out.println("No hay canciones para eliminar");
                    } else {
                        System.out.println("Cancion eliminada: " + playlist.eliminarActual());
                    }
                    break;

                case 5:
                    if (playlist.estaVacia()) {
                        System.out.println("No hay canciones en la playlist");
                    } else {
                        System.out.println("Reproduciendo: " + playlist.actual());
                    }
                    break;

                case 6:
                    if (playlist.estaVacia()) {
                        System.out.println("La playlist esta vacia");
                    } else {
                        System.out.println("\n--- Lista de Canciones ---");
                        int i = 1;
                        for (Cancion c : playlist.listar()) {
                            System.out.println(i++ + ". " + c);
                        }
                    }
                    break;

                case 7:
                    if (playlist.estaVacia()) {
                        System.out.println("No hay canciones para reproducir");
                    } else {
                        System.out.println("\nReproduciendo en modo aleatorio:");
                        for (Cancion c : playlist.ordenAleatorioSinRepetir()) {
                            System.out.println(" > " + c);
                        }
                    }
                    break;

                case 8:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    // Ejercicio 3 - Historial de navegacion tipo browser
    private static void ejecutarHistorialNavegacion() {
        System.out.println("\n=======================================");
        System.out.println("   HISTORIAL DE NAVEGACION            ");
        System.out.println("=======================================");

        System.out.println("\n--- Configuracion Inicial ---");
        System.out.print("URL de la pagina de inicio: ");
        String urlInicio = scanner.nextLine();
        System.out.print("Titulo de la pagina de inicio: ");
        String tituloInicio = scanner.nextLine();

        HistorialNavegacion historial = new HistorialNavegacion(urlInicio, tituloInicio);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu de Historial ---");
            System.out.println("1. Visitar nueva URL");
            System.out.println("2. Retroceder");
            System.out.println("3. Avanzar");
            System.out.println("4. Mostrar historial completo");
            System.out.println("5. Buscar por titulo");
            System.out.println("6. Buscar por URL");
            System.out.println("7. Limpiar historial");
            System.out.println("8. Volver al menu principal");
            System.out.print("Elige una opcion: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    System.out.print("URL: ");
                    String nuevaUrl = scanner.nextLine();
                    System.out.print("Titulo: ");
                    String nuevoTitulo = scanner.nextLine();
                    historial.visitar(nuevaUrl, nuevoTitulo);
                    break;

                case 2:
                    historial.retroceder();
                    break;

                case 3:
                    historial.avanzar();
                    break;

                case 4:
                    historial.mostrarHistorialCompleto();
                    break;

                case 5:
                    System.out.print("Titulo a buscar: ");
                    String titulo = scanner.nextLine();
                    historial.buscarNombre(titulo);
                    break;

                case 6:
                    System.out.print("URL a buscar: ");
                    String url = scanner.nextLine();
                    historial.buscarUrl(url);
                    break;

                case 7:
                    historial.limpiarHistorial();
                    break;

                case 8:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    // Metodo para leer numeros sin que truene el programa
    private static int leerEntero() {
        while (true) {
            try {
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un numero valido: ");
            }
        }
    }
}
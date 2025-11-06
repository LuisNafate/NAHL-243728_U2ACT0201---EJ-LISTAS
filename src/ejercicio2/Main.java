package ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlaylistCircular playlist = new PlaylistCircular();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n   Menu de la playlist circular  ");
            System.out.println("1. Agregar canción");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Eliminar canción actual");
            System.out.println("5. Mostrar canción actual");
            System.out.println("6. Mostrar todas las canciones");
            System.out.println("7. Modo aleatorio sin repetir");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    playlist.agregar(new Cancion(titulo, artista));
                    System.out.println("Canción agregada correctamente.");
                    break;

                case 2:
                    if (playlist.estaVacia()) {
                        System.out.println("Necesitas agregar una canción.");
                    } else {
                        System.out.println("Reproduciendo siguiente: " + playlist.siguiente());
                    }
                    break;

                case 3:
                    if (playlist.estaVacia()) {
                        System.out.println("Necesitas agregar una canción.");
                    } else {
                        System.out.println("Reproduciendo anterior: " + playlist.anterior());
                    }
                    break;

                case 4:
                    if (playlist.estaVacia()) {
                        System.out.println("No hay canciones para eliminar.");
                    } else {
                        System.out.println("Canción eliminada: " + playlist.eliminarActual());
                    }
                    break;

                case 5:
                    if (playlist.estaVacia()) {
                        System.out.println("No hay canciones en la playlist.");
                    } else {
                        System.out.println("Reproduciendo: " + playlist.actual());
                    }
                    break;

                case 6:
                    if (playlist.estaVacia()) {
                        System.out.println("La playlist está vacía.");
                    } else {
                        System.out.println("Lista de canciones:");
                        for (Cancion c : playlist.listar()) {
                            System.out.println(" - " + c);
                        }
                    }
                    break;

                case 7:
                    if (playlist.estaVacia()) {
                        System.out.println("No hay canciones para reproducir en modo aleatorio.");
                    } else {
                        System.out.println("Reproduciendo en modo aleatorio:");
                        for (Cancion c : playlist.ordenAleatorioSinRepetir()) {
                            System.out.println(" * " + c);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}

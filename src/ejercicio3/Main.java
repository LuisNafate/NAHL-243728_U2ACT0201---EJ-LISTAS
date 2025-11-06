package ejercicio3;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        boolean salida=false;
        System.out.println("--- Configuración Inicial del Historial ---");
        System.out.print("Ingresa la URL de la página de inicio: ");
        String urlInicio = scr.nextLine();
        System.out.print("Ingresa el TÍTULO de la página de inicio: ");
        String tituloInicio = scr.nextLine();

        HistorialNavegacion historial = new HistorialNavegacion(urlInicio, tituloInicio);
        historial.mostrarHistorialCompleto();




        while (salida!=true){
            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Visitar una nueva URL");
            System.out.println("2. Retroceder");
            System.out.println("3. Avanzar");
            System.out.println("4. mostrar el historial");
            System.out.println("5. Buscar por url");
            System.out.println("6. Buscar por titulo  ");
            System.out.println("7. Borrar historial");
            System.out.println("8 Salir");
            int opcion = scr.nextInt();
            scr.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese la url ");
                    String nuevaUrl = scr.nextLine();
                    System.out.println("Ingrese el titulo ");
                    String nuevoTitulo = scr.nextLine();
                    historial.visitar(nuevaUrl,nuevoTitulo);
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
                    System.out.println("Escriba el titulo a buscar");
                    String titulo= scr.nextLine();
                    historial.buscarNombre(titulo);
                    break;
                case 6:
                    System.out.println("Escriba la Url a buscar ");
                    String url= scr.nextLine();
                    historial.buscarUrl(url);
                    break;
                case 7:
                    historial.limpiarHistorial();
                    break;
                case 8:
                    salida=true;
                    break;
                default:
                    System.out.println("Porfavor elija una de las opciones ");
            }
        }
    }
}
package ejercicio3;

import ejercicio3.PaginaWeb;

public class HistorialNavegacion {

    //  Punteros
    private PaginaWeb head;
    private PaginaWeb tail;
    private PaginaWeb paginaActual;


    private final int maxHistorial = 10;
    private int tamanoActual;

    public HistorialNavegacion(String urlInicio, String tituloInicio) {
        PaginaWeb paginaInicio = new PaginaWeb(urlInicio, tituloInicio);

        this.head = paginaInicio;
        this.tail = paginaInicio;
        this.paginaActual = paginaInicio;
        this.tamanoActual = 1;
    }


    public void visitar(String url, String titulo) {
        PaginaWeb nuevaPagina = new PaginaWeb(url, titulo);
        System.out.println("Visitando: " + url);

        nuevaPagina.anterior = this.paginaActual;

        if (this.paginaActual.siguiente != null) {
            System.out.println("Borrando historial 'adelante'...");

            this.tail=this.paginaActual;
        }

        this.paginaActual.siguiente = nuevaPagina;
        this.paginaActual = nuevaPagina;
        this.tail = nuevaPagina;

        this.tamanoActual++;

        if (tamanoActual>maxHistorial){
            this.head=this.head.siguiente;
            this.head.anterior=null;
            this.tamanoActual --;
        }
    }
    public void retroceder() {

        if (paginaActual.anterior != null) {
            // Pista 2: Si es así, solo mueve el puntero:
            this.paginaActual = this.paginaActual.anterior;
            System.out.println("Retrocediendo a: " + this.paginaActual.url);
        } else {
            // Pista 3: Si no, imprime un mensaje
            System.out.println("No se puede retroceder más.");
        }
    }


    public void avanzar() {
        if(paginaActual.siguiente!=null){
            this.paginaActual=this.paginaActual.siguiente;
        }else {
            // Pista 3: Si no, imprime un mensaje
            System.out.println("No se puede avanzar más.");
        }

    }


    public void mostrarHistorialCompleto() {
        System.out.println("--- Historial Completo (De más antiguo a más nuevo) ---");
        PaginaWeb temp= this.head;

        while (temp!=null) {

            System.out.println(temp.getDetalles());
            temp = temp.siguiente;
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Página Actual: " + this.paginaActual.url);
    }

    public void buscarUrl(String url) {
        PaginaWeb temp = this.head;
        while (temp != null) {

            if (url.equals(temp.url)) {
                System.out.println("Página encontrada: " + temp.getDetalles());
                return;
            }


            temp = temp.siguiente;
        }
        System.out.println("Pagina no encontrada ");
    }
    public void buscarNombre(String nombre){
        PaginaWeb temp= this.head;
        while (temp != null) {

            if (nombre.equals(temp.titulo)) {
                System.out.println("Página encontrada: " + temp.getDetalles());
                return;
            }


            temp = temp.siguiente;
        }
        System.out.println("Pagina no encontrada ");
    }
    public void limpiarHistorial() {
        this.head = null;
        this.tail = null;
        this.tamanoActual = 0;
        System.out.println("Historial borrado.");
    }
}
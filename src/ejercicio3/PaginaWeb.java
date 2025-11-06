package ejercicio3;

class PaginaWeb {
    String url;
    String titulo;


    PaginaWeb siguiente;
    PaginaWeb anterior;

    public PaginaWeb(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
        this.siguiente = null;
        this.anterior = null;
    }


    public String getDetalles() {

        return "Pagina[URL=" + url + ", Titulo=" + titulo + "]";
    }
}
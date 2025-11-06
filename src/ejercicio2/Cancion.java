package ejercicio2;

public class Cancion {
    private final String titulo;
    private final String artista;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }

    @Override public String toString() {
        return "\"" + titulo + "\" - " + artista;
    }
}

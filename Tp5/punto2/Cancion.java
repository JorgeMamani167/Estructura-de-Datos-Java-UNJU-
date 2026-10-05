package luka.punto2_tp5;

/**
 * @author lucas
 */
public class Cancion {
    private String titulo;
    private String artista;
    private int duracionegundos;
    private int anioLanzamiento;

    public Cancion(String titulo, String artista, int anioLanzamiento, int duracionegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionegundos = duracionegundos;
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracionegundos() {
        return duracionegundos;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDuracionegundos(int duracionegundos) {
        this.duracionegundos = duracionegundos;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    @Override
    public String toString() {
        return "Cancion{" + "titulo=" + titulo + ", artista=" + artista + ", duracionegundos=" + duracionegundos + ", anioLanzamiento=" + anioLanzamiento + '}';
    }
    
    
    
}

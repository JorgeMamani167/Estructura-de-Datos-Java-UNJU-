package luka.punto2_tp5;

/**
 * @author lucas
 */
public class EstadisticaArtista {
    private String nombreArtista;
    private int totalReproducciones;

    public EstadisticaArtista(String nombreArtista, int totalReproducciones) {
        this.nombreArtista = nombreArtista;
        this.totalReproducciones = totalReproducciones;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public void setTotalReproducciones(int totalReproducciones) {
        this.totalReproducciones = totalReproducciones;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public int getTotalReproducciones() {
        return totalReproducciones;
    }
    
    
    
    @Override
    public String toString() {
        return "EstadisticaArtista{" + "nombreArtista=" + nombreArtista + ", totalReproducciones=" + totalReproducciones + '}';
    }
    
    
}

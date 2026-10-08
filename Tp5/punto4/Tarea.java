package luka.punto4_tp5;
import java.time.LocalDate;
/**
 * @author lucas
 */
public class Tarea {
    private int idTarea;
    private String titulo;
    private String responsable;
    private LocalDate fechaLimite;
    private boolean completada;

    public Tarea(int idTarea, String titulo, String responsable, LocalDate fechaLimite, boolean completada) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.responsable = responsable;
        this.fechaLimite = fechaLimite;
        this.completada = completada;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResponsable() {
        return responsable;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarea{");
        sb.append("idTarea=").append(idTarea);
        sb.append(", titulo=").append(titulo);
        sb.append(", responsable=").append(responsable);
        sb.append(", fechaLimite=").append(fechaLimite);
        sb.append(", completada=").append(completada);
        sb.append('}');
        return sb.toString();
    }
    
    
}

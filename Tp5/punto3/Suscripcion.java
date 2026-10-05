package luka.punto3_tp5;

/**
 * @author lucas
 */
import java.time.LocalDate;

public class Suscripcion {
    //podria hacer un id mejor pero uno simple asi que puede pasar que haya dos id iguales
    private String idSuscripcion;
    private String usuario;
    private String plan;//este podria hacer con enum pero no lo hare
    private LocalDate fechaInicio;

    public Suscripcion(String idSuscripcion, String usuario, String plan, LocalDate fechaInicio) {
        this.idSuscripcion = idSuscripcion;
        this.usuario = usuario;
        this.plan = plan;
        this.fechaInicio = fechaInicio;
    }

    public String getIdSuscripcion() {
        return idSuscripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPlan() {
        return plan;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setIdSuscripcion(String idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Suscripcion{" + "idSuscripcion=" + idSuscripcion + ", usuario=" + usuario + ", plan=" + plan + ", fechaInicio=" + fechaInicio + '}';
    }
    
    
}

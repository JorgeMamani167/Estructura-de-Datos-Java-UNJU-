package luka.proyectointegrador;

public class Jugador {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Stack<Carta> pilaPersonal;

    public Jugador(String nombre, String apellido, Integer edad) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.pilaPersonal = new Stack<Carta>(52);
    }

    public String getNombre() {
            return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public String getApellido() {
            return apellido;
    }

    public void setApellido(String apellido) {
            this.apellido = apellido;
    }

    public Integer getEdad() {
            return edad;
    }

    public void setEdad(Integer edad) {
            this.edad = edad;
    }

    public Stack<Carta> getPilaPersonal() {
            return pilaPersonal;
    }

    @Override
    public String toString() {
            return "[Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad + "Cartas" + pilaPersonal.toString() + "]";
    }


}
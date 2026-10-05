package luka.punto1_tp5;

/**
 * @author lucas
 */
public class Producto {
    private String codigo;
    private String nombre;
    private int stock;
    private double precio;
    
    public Producto() {
        this.codigo = "";
        this.nombre = "";
        this.stock = 0;
        this.precio = 0.0;
    }
    
    public Producto(String codigo, String nombre, int stock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + '}';
    }
}

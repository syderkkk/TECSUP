package semana2.teo;

// Elabore una clase PRODUCTO con 3 atributos e implemente encapsulamiento

public class Producto {

    private String codigo;
    private double precio;
    private String descripcion;

    public Producto() {

    }

    public Producto(String codigo, double precio, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

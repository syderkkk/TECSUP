package Semana_02;

public class Producto {

    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public Producto(){
    }

    public Producto(String codigo, String descripcion, int cantidad, double precioUnitario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double calcularPrecioTotal() {
        return this.cantidad * this.precioUnitario;
    }

    public double calcularIGV() {
        double precioTotal = calcularPrecioTotal();
        return precioTotal * 0.18;
    }

    public double calcularTotal() {
        return calcularPrecioTotal() + calcularIGV();
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

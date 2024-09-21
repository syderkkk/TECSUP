package semana5.aplicacion1;

public class Venta {
    private String codigo;
    private String producto;
    private int cantidad;
    private double precio;
    private double subtotal;
    private double igv;
    private double total;

    public Venta(String codigo, String producto, int cantidad, double precio) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularSubtotal() {
        subtotal = precio * cantidad;
        return subtotal;
    }

    public double calcularIgv() {
        igv = subtotal * 0.18;
        return igv;
    }

    public double calcularTotal() {
        total = subtotal + igv;
        return total;
    }

    public void mostrarDetalles() {
        System.out.println("-=======================-");
        System.out.println("Código: " + codigo);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Subtotal: S/ " + calcularSubtotal());
        System.out.println("IGV: S/ " + calcularIgv());
        System.out.println("Total: S/ " + calcularTotal());
        System.out.println("-=======================-");
    }

}

package semana5.aplicacion2;

public class Pedidos implements Constante {
    private int codigo;
    private String producto;
    private int cantidad;
    private double precio;
    private double subtotal;
    private double total;

    public Pedidos(int codigo, String producto, int cantidad, double precio) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int setCodigo() {
        return codigo;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double calcularSubtotal() {
        subtotal = precio * cantidad;
        return subtotal;
    }

    public double calcularIgv() {
        return subtotal * IGV;
    }

    public double calcularTotal() {
        total = calcularSubtotal() + calcularIgv();
        return total;
    }

    public void mostrarDetalles() {
        System.out.println("====================================");
        System.out.println("Código: " + codigo);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: " + precio);
        System.out.println("Subtotal: S/" + String.format("%.2f", calcularSubtotal()));
        System.out.println("Igv: S/" + String.format("%.2f", calcularIgv()));
        System.out.println("Total: S/" + String.format("%.2f", calcularTotal()));
    }
}

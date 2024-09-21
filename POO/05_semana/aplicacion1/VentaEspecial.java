package semana5.aplicacion1;

public class VentaEspecial extends Venta {

    private double igv;
    private double subtotal = calcularSubtotal();
    private double total;

    public VentaEspecial(String codigo, String producto, int cantidad, double precio) {
        super(codigo, producto, cantidad, precio);
    }

    @Override
    public double calcularIgv() {
        igv = subtotal * 0.10;
        return igv;
    }

    @Override
    public double calcularTotal() {
        total = subtotal + igv;
        return total;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("-=======================-");
        System.out.println("Código: " + getCodigo());
        System.out.println("Producto: " + getProducto());
        System.out.println("Cantidad: " + getCantidad());
        System.out.println("Subtotal: S/ " + calcularSubtotal());
        System.out.println("IGV: S/ " + calcularIgv());
        System.out.println("Total: S/ " + calcularTotal());
        System.out.println("-=======================-");
    }

}

package semana2;

public class MainProducto {

    public static void main(String[] args) {
        Producto producto = new Producto("001", "Laptop", 2, 1500);

        System.out.println("Precio total: " + producto.calcularPrecioTotal());
        System.out.println("IGV: " + producto.calcularIGV());
        System.out.println("Total: " + producto.calcularTotal());

    }
}
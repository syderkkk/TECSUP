package semana5.aplicacion1;

import java.util.Scanner;

public class MainVenta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("<---==========--->");
        System.out.println("1. Registrar venta normal (IGV: 18%)");
        System.out.println("2. Registrar venta especial (IGV: 10%)");
        System.out.println("<---==========--->");
        System.out.print("Ingrese su opción: ");

        opcion = scanner.nextInt();

        if (opcion == 1 ) {
            System.out.println("<---==========--->");
            System.out.print("Ingrese el código: ");
            String codigo = scanner.next();
            System.out.print("Ingrese el producto: ");
            String producto = scanner.next();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            System.out.print("Ingrese el precio: S/ ");
            double precio = scanner.nextDouble();

            Venta ventaN = new Venta(codigo, producto, cantidad, precio);
            ventaN.mostrarDetalles();
        } else if (opcion == 2) {
            System.out.println("<---==========--->");
            System.out.print("Ingrese el código: ");
            String codigo = scanner.next();
            System.out.print("Ingrese el producto: ");
            String producto = scanner.next();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            System.out.print("Ingrese el precio: S/ ");
            double precio = scanner.nextDouble();

            Venta ventaE = new VentaEspecial(codigo, producto, cantidad, precio);
            ventaE.mostrarDetalles();
        } else {
            System.out.println("❌ Opción fuera de rango ❌ ");
        }
        scanner.close();
    }
}

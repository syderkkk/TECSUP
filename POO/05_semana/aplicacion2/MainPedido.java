package semana5.aplicacion2;

import java.util.Scanner;

public class MainPedido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código del producto: ");
        int codigo = scanner.nextInt();
        System.out.print("Ingrese el nombre del producto: ");
        String producto = scanner.next();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        Pedidos pedido1 = new Pedidos(codigo, producto, cantidad, precio);
        pedido1.mostrarDetalles();

        scanner.close();
    }
}

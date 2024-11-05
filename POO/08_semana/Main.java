package semana8;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Declaracion objeto MAP
        Map<String, Double> productos = new HashMap<>();

        // Registrar 5 productos con su precio
        productos.put("Manzana", 1.50);
        productos.put("Banana", 0.80);
        productos.put("Naranja", 1.20);
        productos.put("Pera", 1.80);
        productos.put("Mango", 2.00);


        // Imprimir solo precios
        System.out.println("+----------+");
        System.out.printf("| %-8s |%n", "Precio");
        System.out.println("+----------+");
        for (Double precio : productos.values()) {
            System.out.printf("| $%-7.3f |%n", precio);
        }
        System.out.println("+----------+");

        // Imprimir nombres y precios
        System.out.println("\n+----------------+----------+");
        System.out.printf("| %-14s | %-8s |%n", "Producto", "Precio");
        System.out.println("+----------------+----------+");
        for (Map.Entry<String, Double> producto : productos.entrySet()) {
            System.out.printf("| %-14s | $%-7.2f |%n", producto.getKey(), producto.getValue());
        }
        System.out.println("+----------------+----------+");
    }
}

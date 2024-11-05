package semana9.aplicacion2;

public class Fibonacci extends Arreglos {

    public void imprimirSerie(int n) {
        int a = 0, b = 1;
        System.out.println("Serie de Fibonacci hasta " + n + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }
        System.out.println();
    }
}

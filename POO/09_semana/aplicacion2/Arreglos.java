package semana9.aplicacion2;

public class Arreglos implements Constante {

    @Override
    public int Mayor(int[] arreglo) {
        int mayor = arreglo[0];
        for (int num : arreglo) {
            if (num > mayor) {
                mayor = num;
            }
        }
        return mayor;
    }

    @Override
    public int Menor(int[] arreglo) {
        int menor = arreglo[0];
        for (int num : arreglo) {
            if (num < menor) {
                menor = num;
            }
        }
        return menor;
    }

    @Override
    public double Promedio(int[] arreglo) {
        double suma = 0;
        for (int num : arreglo) {
            suma += num;
        }
        return suma / arreglo.length;
    }

    public void imprimir(int[] arreglo) {
        System.out.println("Elementos del arreglo:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

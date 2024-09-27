package semana6.aplicacion1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista ls1 = new Lista();

        System.out.println("¿Cuántos datos desea agregar? ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("\nIngrese los nombres: ");
            ls1.añadirDatos(sc.next());
            System.out.println("Ingrese su edad: ");
            ls1.añadirDatos(sc.nextInt());
        }

        ls1.elementosObtenidos();
        ls1.mostrarDatos();

        sc.close();
    }


}

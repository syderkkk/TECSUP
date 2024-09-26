package semana6.aplicacion2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        int opcion = 0;
        do {
            mostrarMenu();
            System.out.print("️️➡️ Ingrese su opción: ");
            opcion = sc.nextInt();
            if (!validarOpcion(opcion, sc)) continue;

            if (opcion == 1) {
                agregarNumeros(listaNumeros);
            } else if (opcion == 2) {
                eliminarNumero(listaNumeros, sc);
            } else if (opcion == 4) {
                mostrarNumeros(listaNumeros);
            } else if (opcion == 5) {
                break;
            }
        } while (true);
    }


    public static void mostrarMenu() {
        System.out.println("====================");
        System.out.println("1. Agregar números");
        System.out.println("2. Eliminar números");
        System.out.println("3. Cambiar número");
        System.out.println("4. Mostrar números");
        System.out.println("5. Salir");
        System.out.println("====================");
    }

    public static boolean validarOpcion(int opcion, Scanner sc) {
        try {
            if (opcion < 1 || opcion > 5) {
                System.out.println("[❌] Debes ingresar una opcion valida [1:5]!");
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Debes ingresar un número entero [1:5]");
            sc.next();
            System.out.println();
        }
        return true;
    }

    /*
    public static boolean ingresarNumeros(int nIngresado) {
        Scanner sc;
        try {
            int numero
        } catch ()
        return false;
    }
     */

    public static int ingresarNumeros() {
        Scanner sc = new Scanner(System.in);

        int nIngresado = 0;
        do {
            try {
                nIngresado = sc.nextInt();
            } catch (Exception e) {
                System.out.print("[❌] Debes ingresar un número entero: ");
                sc.next();
                continue;
            }
            return nIngresado;
        } while (true);

    }

    public static void agregarNumeros(List<Integer> lista) {
        System.out.print("➡️ Ingrese la cantidad de números que desea añadir: ");
        int cantidad = ingresarNumeros();

        for (int i = 0; i < cantidad; i++) {
            System.out.print((i+1) + " ➡️ Ingrese un número para agregar a la lista: ");
            int numero = ingresarNumeros();
            lista.add(numero);
        }

    }

    /*
    public static void agregarNumeros(List<Integer> lista, Scanner sc) {
        int amount = 0;
        System.out.print("➡️ Ingrese la cantidad de números que desea añadir: ");
        try {
            amount = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e);
            sc.next();
        }

        for (int i = 0; i < amount; i++) {
            System.out.print((i+1) + " ➡️ Ingrese un número para agregar a la lista: ");
            try {
                int numero = sc.nextInt();
                lista.add(numero);
                System.out.println();
                System.out.println("[✅] Número agregado correctamente a la lista.");
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.next();
            }
        }
    }

     */

    public static void mostrarNumeros(List<Integer> lista) {
        if (esVacia(lista)) {
            int count = 0;
            int size = lista.size();

            System.out.println();
            System.out.print("[✅] Números en la lista: ");
            System.out.println();
            for (int numero : lista) {
                System.out.print(numero);
                count++;
                if (count < size) System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static void eliminarNumero(List<Integer> lista, Scanner sc) {
        if (esVacia(lista)) {
            System.out.println();
            System.out.print("➡️ Ingresa el número a eliminar: ");
            try {
                int numero = sc.nextInt();
                while (!lista.remove((Integer) numero)) {
                    System.out.println();
                    System.out.println("[❌] Numero no encontrado!");
                    System.out.println();
                    System.out.print("➡️ Ingresa otro número: ");
                    numero = sc.nextInt();
                    if (lista.remove((Integer) numero)) break;
                }
                System.out.println();
                System.out.println("[✅] Número eliminado correctamente de la lista .");
                System.out.println();
                System.out.println("[✅]");
                System.out.println();

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.next();
            }
        }
    }

    public static boolean esVacia(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println();
            System.out.println("[❌] La lista está vacía.");
            System.out.println();
            return false;
        } else {
            return true;
        }
    }
}
package semana6.aplicacion2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = obtenerOpcion(sc);

            if (opcion == 1) {
                agregarNumeros(listaNumeros);
            } else if (opcion == 2) {
                eliminarNumero(listaNumeros, sc);
            } else if (opcion == 3) {
                cambiarNumero(listaNumeros);
            } else if (opcion == 4) {
                mostrarNumeros(listaNumeros);
            } else if (opcion == 5) {
                cerrarAplicacion();
                break;
            }
        } while (true);
    }

    public static void mostrarMenu() {
        System.out.println("====================");
        System.out.println("➡️ 1. Agregar números");
        System.out.println("️️➡️ 2. Eliminar números");
        System.out.println("️➡️ 3. Cambiar número");
        System.out.println("️➡️ 4. Mostrar números");
        System.out.println("️➡️ 5. Salir");
        System.out.println("====================");
    }

    public static void agregarNumeros(List<Integer> lista) {
        System.out.print("➡️ Ingrese la cantidad de números que desea añadir: ");
        int cantidad = obtenerNumero();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("➡️ " + (i + 1) + ". Ingrese un número para agregar a la lista: ");
            int numero = obtenerNumero();
            lista.add(numero);
        }
        System.out.println("[✅] Números agregados correctamente!");
    }

    public static void eliminarNumero(List<Integer> lista, Scanner sc) {
        if (isListaVacia(lista)) {
            System.out.print("➡️ Ingrese el número a eliminar: ");

            int numero = obtenerNumero();

            while (!lista.remove((Integer) numero)) {
                System.out.println("[❌] Numero no encontrado!");
                System.out.print("➡️ Ingresa otro número: ");
                numero = obtenerNumero();
            }
            System.out.println("[✅] Número eliminado correctamente!");
        }
    }

    public static void cambiarNumero(List<Integer> lista) {
        if (isListaVacia(lista)) {
            int indice = 0;
            int numero = 0;

            do {
                System.out.print("➡️ Ingrese el índice [1 - " + lista.size() + "]: ");
                indice = obtenerNumero();
            } while (indice <= 0 || indice > lista.size());
            indice--;

            System.out.print("➡️ Ingrese el nuevo número: ");
            numero = obtenerNumero();

            lista.set(indice, numero);
            System.out.println("[✅] Número cambiado correctamente!");
        }
    }

    public static void mostrarNumeros(List<Integer> lista) {
        if (isListaVacia(lista)) {
            int count = 0;
            int size = lista.size();

            System.out.println();
            System.out.print("[✅] Números en la lista: ");

            for (int numero : lista) {
                System.out.print(numero);
                count++;
                if (count < size) System.out.print(", ");
            }
            System.out.println("\n");
        }
    }

    public static boolean isListaVacia(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("[❌] La lista está vacía!");
            return false;
        } else {
            return true;
        }
    }

    public static int obtenerOpcion(Scanner sc) {
        int opcion = 0;

        do {
            System.out.print("️️➡️ Ingrese su opción: ");
            try {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 5) System.out.println("[❌] Debes ingresar un número entero [1:5]");
            } catch (Exception e) {
                sc.next();
                System.out.println("[❌] Debes ingresar un número entero");
            }
        } while (opcion < 1 || opcion > 5);
        return opcion;
    }

    public static int obtenerNumero() {
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

    public static void cerrarAplicacion() {
        try {
            System.out.println("➡️ Cerrando el menú en... 3 ");
            for (int i = 2; i > 0; i--) {
                Thread.sleep(1000);
                System.out.println("➡️ Cerrando el menú en... " + i);
            }
        } catch (InterruptedException e) {
            System.out.println("[❌] Error al cerrar el menú!");
        }
        System.out.println("[📴] Cerrado!");
    }
}
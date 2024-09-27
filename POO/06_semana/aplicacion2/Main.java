package semana6.aplicacion2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        int opcion = 0; // Variable para almacenar la opción del menú

        // Bucle para mostrar el menú y realizar acciones según la opción selecconada
        do {
            mostrarMenu();
            opcion = obtenerOpcion(sc); //

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

    public static int obtenerOpcion(Scanner sc) {
        int opcion = 0;

        do {
            System.out.print("️️➡️ Ingrese su opción: ");
            try {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 5) System.out.println("[❌] Debes ingresar un número entero [1:5]");
            } catch (Exception e) {
                sc.next(); // Limpia el buffer en caso de exepción
                System.out.println("[❌] Debes ingresar un número entero");
            }
        } while (opcion < 1 || opcion > 5); // Repite hasta obtener una opción válida
        return opcion; // Retorna la opción válida
    }

    public static void agregarNumeros(List<Integer> lista) {
        System.out.print("➡️ Ingrese la cantidad de números que desea añadir: ");
        int cantidad = obtenerNumero(); // Obtiene la cantidad de números a agregar

        for (int i = 0; i < cantidad; i++) {
            System.out.print("➡️ " + (i + 1) + ". Ingrese un número para agregar a la lista: ");
            int numero = obtenerNumero(); // Obtiene el número a agregar
            lista.add(numero); // Agrega el número a la lista
        }
        // Mensaje de confirmación según la cantidad de números agregados
        System.out.println(
                cantidad > 1 ? "[✅] Números agregados correctamente!" : "[✅] Número agregado correctamente!"
        );
    }

    public static void eliminarNumero(List<Integer> lista, Scanner sc) {
        //Verifica si la lista contiene elementos antes de eliminar
        if (contieneElementos(lista)) {
            System.out.print("➡️ Ingrese el número a eliminar: ");

            int numero = obtenerNumero(); // Obtiene el número a eliminar

            // Intenta eliminar el número y pide otro si no se encuentra
            while (!lista.remove((Integer) numero)) {
                System.out.println("[❌] Número no encontrado!");
                System.out.print("[➡️ Números disponibles: ");
                mostrarNumeros(lista);
                System.out.print("➡️ Ingresa otro número: ");
                numero = obtenerNumero(); // Solicita un nuevo número
            }
            System.out.println("[✅] Número eliminado correctamente!");
        }
    }

    public static void cambiarNumero(List<Integer> lista) {
        // Verifica si la lista contiene elementos antes de cambiar
        if (contieneElementos(lista)) {
            int indice = 0;
            int numero = 0;

            // Bucle para solicitar un índice válido para cambiar el número
            do {
                System.out.print("➡️ Ingrese el índice [1 - " + lista.size() + "]: ");
                indice = obtenerNumero();
            } while (indice <= 0 || indice > lista.size()); // Verifica que el índice sea válido
            indice--; // Ajusta el índice para el acceso a la lista

            System.out.print("➡️ Ingrese el nuevo número: ");
            numero = obtenerNumero(); // Obtiene nuevo número

            lista.set(indice, numero); // Cambia el número en la lista
            System.out.println("[✅] Número cambiado correctamente!");
        }
    }

    public static void mostrarNumeros(List<Integer> lista) {
        // Verifica si la lista cntiene elementos antes de mostrarla
        if (contieneElementos(lista)) {
            int count = 0;
            int size = lista.size();

            System.out.println();
            System.out.print("[✅] Números en la lista: ");

            for (int numero : lista) {
                System.out.print(numero);
                count++;
                if (count < size) System.out.print(", "); // Formatea la salida
            }
            System.out.println("\n");
        }
    }

    public static boolean contieneElementos(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("[❌] La lista está vacía!");
            return false; // Retorna false si está vacía
        } else {
            return true; // Retorna true si no está vacía
        }
    }

    public static int obtenerNumero() {
        Scanner sc = new Scanner(System.in);

        int nIngresado = 0;
        do {
            try {
                nIngresado = sc.nextInt();
            } catch (Exception e) {
                System.out.print("[❌] Debes ingresar un número entero: ");
                sc.next(); // Limpia el buffer en caso encuentre una exepción
                continue; // Vuelve a pedir el número
            }
            return nIngresado; // Retorna el número ingresado
        } while (true); // Repite hasta obtener un número válido

    }

    public static void cerrarAplicacion() {
        try {
            System.out.println("➡️ Cerrando el menú en... 3 ");
            // Cuenta regresiva para cerrar la aplicación
            for (int i = 2; i > 0; i--) {
                Thread.sleep(1000); // Pausas de 1 segundo
                System.out.println("➡️ Cerrando el menú en... " + i);
            }
        } catch (InterruptedException e) {
            System.out.println("[❌] Error al cerrar el menú!");
        }
        System.out.println("[📴] Cerrado!");
    }
}
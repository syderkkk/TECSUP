package semana8.aplicacion2;

import java.util.Scanner;

public class MainEncuesta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encuesta encuesta = new Encuesta();

        // Solicitar los valores al usuario
        System.out.print("Ingrese el nombre de usuario: ");
        encuesta.setUsuario(scanner.nextLine());

        System.out.print("Ingrese el sexo (M/F): ");
        encuesta.setSexo(scanner.nextLine());

        System.out.print("Ingrese el email: ");
        encuesta.setEmail(scanner.nextLine());

        System.out.print("Ingrese su buscador favorito: ");
        encuesta.setBuscador(scanner.nextLine());

        // Guardar los datos en un archivo plano
        encuesta.guardarArchivo("encuesta.txt");

        // Imprimir los valores registrados
        System.out.println("\nValores ingresados:");
        encuesta.imprimirValores();

        scanner.close();
    }
}

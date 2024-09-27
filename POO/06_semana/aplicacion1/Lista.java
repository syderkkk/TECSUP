package semana6.aplicacion1;

import java.util.ArrayList;

public class Lista {

    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<Integer> edades = new ArrayList<>();

    public void añadirDatos(String nombre) {
        nombres.add(nombre);
    }

    public void añadirDatos(int edad) {
        edades.add(edad);
    }

    public void elementosObtenidos() {
        System.out.println("\nNombres obtenidos: ");

        for (String elemento : nombres) {
            System.out.println(elemento);
        }
        System.out.println("Edades obtenidas: ");
        for (int elemento: edades) {
            System.out.println(elemento);
        }
    }

    public void mostrarDatos() {
        System.out.println("\n-----MOSTRAR DATOS----");
        for (int i = 0; i < nombres.size(); i++) {
            String nombre = nombres.get(i);
            int edad = edades.get(i);
            System.out.println(nombre + " tiene " + edad + " años.");
        }
    }
}

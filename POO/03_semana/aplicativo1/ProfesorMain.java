package semana3.aplicativo1;

public class ProfesorMain {

    public static void main(String[] args) {

        Profesor profesor1 = new Profesor(1, 1, "Carlos", 10);
        Profesor profesor2 = new Profesor(2, 1, "Carlos", 15);
        Profesor profesor3 = new Profesor(3, 1, "Carlos", 20);

        System.out.println("====================");
        System.out.println("Cantidad de objetos creados: " + Profesor.getContadorObj());
        System.out.println("Suma de todos los sueldos: " + Profesor.getSumaSueldos());
        System.out.println("====================");
        System.out.println();
        // Prueba del metodo listado
        metodoListado(profesor1);
    }

    public static void metodoListado(Profesor profesor) {
        System.out.println("====================");
        System.out.println("Codigo: " + profesor.getCodigo());
        System.out.println("Nombre: " + profesor.getNombre());
        System.out.println("Horas trabajadas: " + profesor.getHorasTrabajadas());
        System.out.println("Tarifa por horas: " + profesor.getTarifaPorHoras());
        System.out.println("Sueldo del docente: " + profesor.calcularSueldo());
        System.out.println("====================");
    }
}

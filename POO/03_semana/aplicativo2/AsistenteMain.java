package semana3.aplicativo2;

public class AsistenteMain {

    public static void main(String[] args) {

        Asistente asistente = new Asistente(1, "Gerardo", 1, 1500);
        // Uso del metodo listado
        metodoListado(asistente);
        // Cantidad de objetos creados y la suma de los sueldos
        System.out.println("Cantidad de objetos creados: " + Asistente.getContadorObj());
        System.out.println("Suma de los sueldos: " + Asistente.getSueldosAcumalados());
        // Uso del metodo indicador de sueldo
        System.out.println("El sueldo es: " + asistente.indicadorSueldo());
        // Reinicializando en cero el contador y el acumulador
        Asistente.setContadorObj(0);
        System.out.println("El nuevo contador es: " + Asistente.getContadorObj());
        Asistente.setSueldosAcumalados(0);
        System.out.println("El nuevo sueldo acumulado es: " + Asistente.getSueldosAcumalados());
    }

    public static void metodoListado(Asistente asistente) {
        System.out.println("====================");
        System.out.println("Codigo: " + asistente.getCodigo());
        System.out.println("Nombre: " + asistente.getNombre());
        System.out.println("DNI: " + asistente.getDni());
        System.out.println("Sueldo en soles: " + asistente.getSueldoEnSoles());
        System.out.println("====================");
    }
}

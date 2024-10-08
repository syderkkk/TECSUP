package Semana7.Aplicacion;

public class Main {

    public static void main(String[] args) {
        Operaciones op = new Operaciones();

        op.registrarCuenta(1, 5, "A", "Carlos");
        op.registrarCuenta(2, 6, "B", "Denis");
        op.registrarCuenta(3, 7, "C", "Andre");
        op.registrarCuenta(4, 8, "D", "Belinda");

        Interfaz interfaz = new Interfaz(op);
        interfaz.setVisible(true);
    }
}

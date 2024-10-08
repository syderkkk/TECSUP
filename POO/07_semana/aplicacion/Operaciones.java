package Semana7.Aplicacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Operaciones {
    // Registrar cuentas, imprimir cuentas, buscar cuentas, eliminar cuenta y ordenamiento de datos
    private List<Cuenta> cuentas = new ArrayList<>();
    private Cuenta cuenta;

    // Registrar cuentas
    public void registrarCuenta(int numero, double sueldo, String tipoCliente, String nombre) {
        cuenta = new Cuenta(numero, sueldo, tipoCliente, nombre);
        cuentas.add(cuenta);
    }

    // Imprimir cuentas
    public String imprimirCuenta() {
        StringBuilder sb = new StringBuilder();
        for (Cuenta cuenta : cuentas) {
            sb.append(cuenta.toString()).append("\n");
        }
        return sb.toString();
    }

    // Buscar cuentas
    public String buscarCuenta(int numero){
        for (Cuenta iterator : cuentas) {
            if (iterator.getNumero() == numero) {
                return iterator.toString();
            }
        }
        return "No se encontro!";
    }

    // Eliminar cuentas
    public void eliminarCuenta(int numero) {
        for (Cuenta iterator : cuentas) {
            if (iterator.getNumero() == numero) {
                cuentas.remove(iterator);
            }
        }
    }

    // Ordenar segun criterio
    public void ordenarSegunCriterio(String criterio) {
        if (criterio.equalsIgnoreCase("numero")) {
            cuentas.sort(Comparator.comparing(Cuenta::getNumero));
        } else if (criterio.equalsIgnoreCase("nombre")) {
            cuentas.sort(Comparator.comparing(Cuenta::getNombre));
        } else if (criterio.equalsIgnoreCase("saldo")) {
            cuentas.sort(Comparator.comparing(Cuenta::getSaldo));
        }
    }

}

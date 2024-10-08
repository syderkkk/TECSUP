package Semana7.Aplicacion;

public class Cuenta {

    private int numero;
    private String nombre;
    private String tipoCliente;
    private double saldo;

    public Cuenta(int numero, double saldo, String tipoCliente, String nombre) {
        this.numero = numero;
        this.saldo = saldo;
        this.tipoCliente = tipoCliente;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "➡️ Cuenta {" +
                " numero= " + numero +
                ", nombre='" + nombre + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", saldo=" + saldo +
                " }";
    }
}

package semana3.aplicativo2;

public class Asistente {

    private int codigo;
    private String nombre;
    private int dni;
    private double sueldoEnSoles;

    private static int contadorObj;
    private static double sueldosAcumalados;

    public Asistente(int codigo, String nombre, int dni, double sueldoEnSoles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dni = dni;
        this.sueldoEnSoles = sueldoEnSoles;

        contadorObj++;
        sueldosAcumalados += sueldoEnSoles;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSueldoEnSoles() {
        return sueldoEnSoles;
    }

    public void setSueldoEnSoles(double sueldoEnSoles) {
        this.sueldoEnSoles = sueldoEnSoles;
    }

    public static int getContadorObj() {
        return contadorObj;
    }

    public static void setContadorObj(int contadorObj) {
        Asistente.contadorObj = contadorObj;
    }

    public static double getSueldosAcumalados() {
        return sueldosAcumalados;
    }

    public static void setSueldosAcumalados(double sueldosAcumalados) {
        Asistente.sueldosAcumalados = sueldosAcumalados;
    }

    public String indicadorSueldo() {
        if (this.sueldoEnSoles > 1500) {
            return "mayor a 1500";
        } else if (this.sueldoEnSoles == 1500) {
            return "igual a 1500";
        } else {
            return "menor a 1500";
        }
    }
}

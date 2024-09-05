package semana3.aplicativo1;

public class Profesor {
    // Atributos privados
    private int codigo;
    private int horasTrabajadas;
    private String nombre;
    private double tarifaPorHoras;
    // Variables privadas de la clase
    private static int contadorObj;
    private static double sumaSueldos;
    // Metodo constructor
    public Profesor(int codigo, int horasTrabajadas, String nombre, double tarifaPorHoras) {
        this.codigo = codigo;
        this.horasTrabajadas = horasTrabajadas;
        this.nombre = nombre;
        this.tarifaPorHoras = tarifaPorHoras;

        contadorObj++;
        sumaSueldos += calcularSueldo();
    }
    // Metodos get/set para todos los atributos privados
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getTarifaPorHoras() {
        return tarifaPorHoras;
    }

    public void setTarifaPorHoras(double tarifaPorHoras) {
        this.tarifaPorHoras = tarifaPorHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    // Metodos get/set para las variables privadas de la clase
    public static int getContadorObj() {
        return contadorObj;
    }

    public static void setContadorObj(int contadorObj) {
        Profesor.contadorObj = contadorObj;
    }

    public static double getSumaSueldos() {
        return sumaSueldos;
    }

    public static void setSumaSueldos(double sumaSueldos) {
        Profesor.sumaSueldos = sumaSueldos;
    }
    // Metodo que retorna el sueldo del docente
    public double calcularSueldo() {
        return this.horasTrabajadas * this.tarifaPorHoras;
    }
}

package semana2.teo;

// Elabore una clase EMPLEADO con 4 atributos y un constructor sin parámetros y otro con parámetros

public class Empleado {

    String nombre;
    String rango;
    int dni;
    double sueldo;

    public Empleado(){

    }

    public Empleado(String nombre, String rango, int dni, double sueldo){
        this.nombre = nombre;
        this.rango = rango;
        this.dni = dni;
        this.sueldo = sueldo;
    }
}

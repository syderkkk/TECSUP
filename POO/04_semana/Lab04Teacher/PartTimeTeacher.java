package semana4.Lab04Teacher;

public class PartTimeTeacher extends Teacher {

    private int hours;
    private double rate;

    public PartTimeTeacher(String name, String surname, String dni, int hours, double rate) {
        super(name, dni, surname);
        this.hours = hours;
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDetails() {
        return "Name: " + name + "\nSurname: " + surname + "\nDNI: " + dni + "\nHours: " + hours + "\nRate: " + rate;
    }

    public double grossSalary() {
        return hours * rate;
    }
}

package semana4.Lab04Teacher;

public class FullTimeTeacher extends Teacher {

    private double baseSalary;
    private double bonusPercentage;

    public FullTimeTeacher(String name, String dni, String surname, double baseSalary, double bonusPercentage) {
        super(name, dni, surname);
        this.baseSalary = baseSalary;
        this.bonusPercentage = bonusPercentage;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    public String getDetails() {
        return "Name: " + name + "\nSurname: " + surname + "\nDNI: " + dni + "\nBase Salary: " + baseSalary + "\nBonus Percentage: " + bonusPercentage;
    }

    public double getBonus() {
        return baseSalary * bonusPercentage / 100;
    }

    public double grossSalary() {
        return baseSalary + getBonus();
    }
}

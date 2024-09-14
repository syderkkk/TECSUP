package semana4.Lab04Applicant;

public class Applicant extends Person {

    private double note1;
    private double note2;

    public Applicant(String name, String dni, String address, double note1, double note2) {
        super(name, dni, address);
        this.note1 = note1;
        this.note2 = note2;
    }

    public double getNote1() {
        return note1;
    }

    public void setNote1(double note1) {
        this.note1 = note1;
    }

    public double getNote2() {
        return note2;
    }

    public void setNote2(double note2) {
        this.note2 = note2;
    }

    public String getApplicationCode() {
        return getName().charAt(0) + getDni();
    }

    public double getAverageNote() {
        return (note1 + note2 * 2) / 3;
    }

    public String getResult() {
        return getAverageNote() >= 14 ? "Accepted" : "Rejected";
    }
}

package semana4.Lab04Applicant;

public class Main {

    public static void main(String[] args) {

        // Test case 1:
        Applicant applicant1 = new Applicant("Jhon", "-123456", "Lima", 15, 16);
        System.out.println("Application Code: " + applicant1.getApplicationCode());
        System.out.println("Application Average Note: " + applicant1.getAverageNote());
        System.out.println("Result: " + applicant1.getResult());

        // Test case 2:
        Applicant applicant2 = new Applicant("Alice", "-123456", "Miraflores", 14, 14);
        System.out.println("Application Code: " + applicant2.getApplicationCode());
        System.out.println("Application Average Note: " + applicant2.getAverageNote());
        System.out.println("Result: " + applicant2.getResult());

        // Test case 3:
        Applicant applicant3 = new Applicant("Roger", "-123456", "Surco", 10, 12);
        System.out.println("Application Code: " + applicant3.getApplicationCode());
        System.out.println("Application Average Note: " + applicant3.getAverageNote());
        System.out.println("Result: " + applicant3.getResult());
    }
}

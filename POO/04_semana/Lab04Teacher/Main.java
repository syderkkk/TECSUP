package semana4.Lab04Teacher;

public class Main {

    public static void main(String[] args) {
        // Test case 1:
        PartTimeTeacher ptTeacher = new PartTimeTeacher("Leonardo", "Flores", "123456", 20, 50);
        System.out.println("Part-Time Teacher Details: \n" + ptTeacher.getDetails());
        System.out.println("Gross Salary: " + ptTeacher.grossSalary());
        System.out.println("------------------------");

        // Test case 2:
        FullTimeTeacher ftTeacher1 = new FullTimeTeacher("Laura", "Rosales", "123456", 2000, 10);
        System.out.println("Full-Time Teacher Details:\n" + ftTeacher1.getDetails());
        System.out.println("Gross Salary: " + ftTeacher1.grossSalary());
        System.out.println("------------------------");

        // Test case 3:
        FullTimeTeacher ftTeacher2 = new FullTimeTeacher("Rosa", "Galindo", "77777777", 2500, 25);
        System.out.println("Full-Time Teacher Details:\n" + ftTeacher2.getDetails());
        System.out.println("Gross Salary: " + ftTeacher2.grossSalary());
        System.out.println("------------------------");
    }
}

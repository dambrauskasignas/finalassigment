import java.util.Scanner;

public class StudentPanel {
    public static void StudentMenu() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.println("Get course list");
                break;
            case 2:
                System.out.println("Get registered course list");
                break;
            case 3:
                System.out.println("Enrole Cource");
                break;
            case 4:
                Login.run();
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }
    public static void printStudentMenu() {
        System.out.println("1. Get course list");
        System.out.println("2. Get registered course list");
        System.out.println("3. Enrole cource");
        System.out.println("4. Log Out");
    }
}

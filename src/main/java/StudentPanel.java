import java.util.Scanner;

public class StudentPanel {
    public static void StudentMenu() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.println("Current course list:");
                Course.getCoursesList();
                break;
            case 2:
                StudentRegistration.getEnrolledCoursesList();
                break;
            case 3:
                StudentRegistration.enterCourseNameToEnroll();
                break;
            case 4:
                System.out.println("Please choose what do you want to change:");
                UserChanges.printUserChangeChoice();
                UserChanges.userChoicesSelector();
                break;
            case 5:
                System.out.println("Session ended. Thank You");
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
        System.out.println("4. Change my details");
        System.out.println("5. Logout");
    }

}
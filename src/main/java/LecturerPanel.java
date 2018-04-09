import java.util.Scanner;

public class LecturerPanel {
    public static void lecturerMenu() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 2:
                printLecturerCourseChangeMenu();
                lecturerCourseChangeMenu();
                break;
            case 3:
                Course.getSpecifiedCoursesList();
                break;
            case 4:
                StudentRegistration.getEnrolledStudentList();
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

    public static void printLecturerMenu() {
        System.out.println("1. Add course");
        System.out.println("2. Add/Change/Delete course");
        System.out.println("3. Get owned course list");
        System.out.println("4. Get course student list");
        System.out.println("5. Log Out");
    }
    static void printLecturerCourseChangeMenu() {
        System.out.println("1. Add course");
        System.out.println("2. Change course details");
        System.out.println("3. Delete course");
        System.out.println("4. Return");
    }

    public static void lecturerCourseChangeMenu() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                Course.addCourse();
                break;
            case 2:
                Course.printLecturerChangeChoice();
                Course.LecturerChangesChoicesSelector();
                break;
            case 3:
                System.out.println("Please choose which course to delete");
                Course.deleteCourse();
                break;
            case 4:
                lecturerMenu();
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }
}


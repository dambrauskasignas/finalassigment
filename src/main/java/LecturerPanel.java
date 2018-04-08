import java.util.Scanner;

public class LecturerPanel {
    public static void LecturerMenu() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.println("Cource added");
                break;
            case 2:
                System.out.println("Cource Changed/Removed");
                break;
            case 3:
                System.out.println("Get owned cource list");
                break;
            case 4:
                System.out.println("Get course student list");
                break;
            case 5:
                Login.run();
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }
    public static void printLecturerMenu() {
        System.out.println("1. Add course");
        System.out.println("2. Change/Remove course");
        System.out.println("3. Get owned course list");
        System.out.println("4. Get course student list");
        System.out.println("5. Log Out");
    }
}


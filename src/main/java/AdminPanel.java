import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {

    public static void adminMenu() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                addUser();
                System.out.println("User added");
                break;
            case 2:
                System.out.println("Change course details");
                break;
            case 3:
                System.out.println("Get student list");
                break;
            case 4:
                System.out.println("Get course list");
                break;
            case 5:
                Login.run();
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }

    public static void addUser() {
        List<String> userProperties = new ArrayList<>();


        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt", true))
        ) {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 5; i++)

            {
                System.out.println("Enter name");
                String input = sc.nextLine();
                userProperties.add(String.valueOf(input));
            }
            bufferedWriter.newLine();
            bufferedWriter.write(String.join(";", userProperties));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void printAdminMenu() {
        System.out.println("1. Add new user");
        System.out.println("2. Change course details");
        System.out.println("3. Get student list");
        System.out.println("4. Get course list");
        System.out.println("5. Log Out");
    }
}

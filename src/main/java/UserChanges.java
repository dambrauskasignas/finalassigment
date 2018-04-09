import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserChanges {

    public static void printUserChangeChoice() {
        System.out.println("1. Change firstName");
        System.out.println("2. Change lastName");
        System.out.println("3. Change personalNumber");
        System.out.println("4. Change dateOfBirth");
        System.out.println("5. Change email");
        System.out.println("6. Change mobileNumber");
        System.out.println("7. Change gender");
        System.out.println("8. Change address");
        System.out.println("9. Return");
    }

    public static void userChoicesSelector() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                changeUserInfo(2);
                System.out.println("First Name Changed");
                break;
            case 2:
                changeUserInfo(3);
                System.out.println("Last Name Changed");
                break;
            case 3:
                changeUserInfo(4);
                System.out.println("Personal Number Changed");
                break;
            case 4:
                changeUserInfo(5);
                System.out.println("dateOfBirth Changed");
                break;
            case 5:
                changeUserInfo(6);
                System.out.println("Email Changed");
                break;
            case 6:
                changeUserInfo(7);
                System.out.println("Mobile number Changed");
                break;
            case 7:
                changeUserInfo(8);
                System.out.println("Gender Changed");
                break;
            case 8:
                changeUserInfo(9);
                System.out.println("Address Changed");
                break;
            case 9:
                StudentPanel.printStudentMenu();
                StudentPanel.StudentMenu();
                break;

            default:
                System.out.println("Wrong input.");
                break;
        }
    }


    public static void changeUserInfo(int userChoice) {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("users.txt");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(";")[0].equals(Login.loggedUser().getUserName())) {
                    System.out.println("Enter new parameter:");
                    List<String> splited = Arrays.asList(line.split(";"));
                    Scanner sc = new Scanner(System.in);
                    String inpUser = sc.nextLine();
                    splited.set(userChoice, inpUser);
                    line = splited.stream().collect(Collectors.joining(";"));
                    Login.loggedUser().setUserName(inpUser);
                }
                userStgrings.add(line);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile))
        ) {
            for (String line : userStgrings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

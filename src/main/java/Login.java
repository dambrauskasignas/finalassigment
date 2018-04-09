import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    private static User loggedUser;

    public static boolean run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user ID");
        String inpUser = sc.nextLine();
        System.out.println("Enter user Pass");
        String inpPass = sc.nextLine();

        getUser(inpUser);


        if (inpUser.equals(loggedUser.getUserName()) && inpPass.equals(loggedUser.getPassword())) {
            System.out.println("Hello, " + loggedUser.getUserName());
            return true;
        } else {
            System.out.print("This user does not exists");
            return false;
        }
    }

    public static User loggedUser() {
        return loggedUser;
    }

    public static void getUser(String username) {
        loggedUser = new User();
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");

                if (username.equals(split[0])) {
                    loggedUser.setUserName(split[0]);
                    loggedUser.setPassword(split[1]);
                    loggedUser.setFirstName(split[2]);
                    loggedUser.setLastName(split[3]);
                    loggedUser.setPersonalNumber(split[4]);
                    loggedUser.setDateOfBirth(split[5]);
                    loggedUser.setEmail(split[6]);
                    loggedUser.setMobileNumber(split[7]);
                    loggedUser.setGender(split[8]);
                    loggedUser.setAddress(split[9]);
                    loggedUser.setRunningCourses(split[10]);
                    loggedUser.setRole(split[11]);
                }

                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void roleSelector() {
        switch (loggedUser.getRole()) {
            case "admin":
                AdminPanel.printAdminMenu();
                AdminPanel.adminMenu();
                break;
            case "lecturer":
                LecturerPanel.printLecturerMenu();
                LecturerPanel.lecturerMenu();
                break;
            case "student":
                StudentPanel.printStudentMenu();
                StudentPanel.StudentMenu();
                break;
            default:
                System.out.println("Wrong Role");
                break;
        }
    }
}
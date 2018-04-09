import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {

    public static void adminMenu() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                printUserAddChoicesSelector();
                userAddChoicesSelector();
                break;
            case 2:
                System.out.println("Choose what do you want to change:");
                printadminCourseChangeMenu();
                adminCourseChangeMenu();
                break;
            case 3:
                System.out.println("Current student list:");
                getAdminStudentList();
                break;
            case 4:
                System.out.println("Current course list:");
                getAdminCourseList();
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

    public static void printUserAddChoicesSelector() {
        System.out.println("1. Add new Admin");
        System.out.println("2. Add new Student");
        System.out.println("3. Add new Lecturer");
        System.out.println("4. Return");
    }

    public static void userAddChoicesSelector() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                addUser("admin");
                break;
            case 2:
                addUser("student");
                break;
            case 3:
                addUser("lecturer");
                break;
            case 4:
                printAdminMenu();
                adminMenu();
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }

    public static void addUser(String userRoleChoice) {
        List<String> userProperties = new ArrayList<>();
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt", true))
        ) {
            String[] enterOprions = {"Enter User ID", "Enter Password", "Enter First Name", "Enter Last Name"};

            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < enterOprions.length; i++) {
                System.out.println(enterOprions[i]);
                String input = sc.nextLine();
                userProperties.add(i, String.valueOf(input));
            }
            for (int i = 4; i < 11; i++) {
                userProperties.add(i, "default");
            }
            userProperties.add(11, userRoleChoice);
            bufferedWriter.newLine();
            bufferedWriter.write(String.join(";", userProperties));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void printAdminMenu() {
        System.out.println("1. Add new user");
        System.out.println("2. Add/Change/Delete course");
        System.out.println("3. Get student list");
        System.out.println("4. Get course list");
        System.out.println("5. Log Out");
    }

    public static void getAdminStudentList() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"))) {
            String line = bufferedReader.readLine();
            System.out.println("1.First name/2.Last name/3.Personal Number/4.DateOfBirth/5.Email/6.Mobile Number/7.Gender/8.Adress/9.Running Courses");
            while (line != null) {
                String[] split = line.split(";");
                if (split[11].equals("student")) {
                    String adminStudentList = "1. " + split[2] + " 2. " + split[3] + " 3. " + split[4] + " 4. " + split[5] + " 5. " + split[6] + " 6. " + split[7] + " 7. " + split[8] + " 8. " + split[9] + " 9. " + split[10];
                    line = bufferedReader.readLine();
                    System.out.println(adminStudentList);
                } else {
                    line = bufferedReader.readLine();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getAdminCourseList() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("courses.txt"))) {
            String line = bufferedReader.readLine();
            System.out.println("1.Code/2.title/3.Description/4.Start Date /5.Credit/6.Lecturer ID");
            line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                String AdminCourseList = "1. " + split[0] + " 2. " + split[1] + " 3. " + split[2] + " 4. " + split[3] + " 5. " + split[4] + " 6. " + split[5];
                System.out.println(AdminCourseList);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printadminCourseChangeMenu() {
        System.out.println("1. Add course");
        System.out.println("2. Change course details");
        System.out.println("3. Delete course");
        System.out.println("4. Return");
    }

    public static void adminCourseChangeMenu() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.println("Enter new course details:");
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
                adminMenu();
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }
}

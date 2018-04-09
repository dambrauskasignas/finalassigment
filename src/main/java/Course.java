import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Course {

    public static void getCoursesList() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("courses.txt"))) {
            String line = bufferedReader.readLine();
            System.out.println("1. Course Code/2. Course Title");
            while (line != null) {
                String[] split = line.split(";");
                String courseList = "1. " + split[0] + " 2. " + split[1];
                line = bufferedReader.readLine();
                System.out.println(courseList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getSpecifiedCoursesList() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("courses.txt"))) {
            String line = bufferedReader.readLine();
            System.out.println("Current course list:");
            while (line != null) {
                String[] split = line.split(";");
                if (split[5].equals(Login.loggedUser().getUserName())) {
                    System.out.println(split[1]);
                    line = bufferedReader.readLine();
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

    public static void addCourse() {
        List<String> courseProperties = new ArrayList<>();
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("courses.txt", true))
        ) {
            String[] enterOprions = {"Enter course title", "Enter course description", "Enter course start date (format: YYYYMMDD)", "Enter course credit"};

            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < enterOprions.length; i++) {
                System.out.println(enterOprions[i]);
                String input = sc.nextLine();
                courseProperties.add(String.valueOf(input));
            }
            courseProperties.add(0, String.valueOf(IDGenerator.CourseIDGenerator()));
            if (Login.loggedUser().getRole() == "lecturer") {
                courseProperties.add(5, String.valueOf(Login.loggedUser().getUser_ID()));
            } else {
                courseProperties.add(5, "default");
            }
            bufferedWriter.newLine();
            bufferedWriter.write(String.join(";", courseProperties));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void deleteCourse() {
        List<String> userStrings = new ArrayList<>();
        File usersFile = new File("courses.txt");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            System.out.println("Enter course code");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.split(";")[0].equals(input)) {
                    userStrings.add(line);
                } else {
                    System.out.println("Entered course does not exist");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile))
        ) {
            for (String line : userStrings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LecturerChangesChoicesSelector() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                changeCourseInfo(2);
                System.out.println("Title Changed");
                break;
            case 2:
                changeCourseInfo(3);
                System.out.println("Description Changed");
                break;
            case 3:
                changeCourseInfo(4);
                System.out.println("Start Date Changed");
                break;
            case 4:
                changeCourseInfo(5);
                System.out.println("Credit Changed");
                break;
            case 5:
                LecturerPanel.printLecturerMenu();
                LecturerPanel.lecturerMenu();
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }

    public static void changeCourseInfo(int lecturerChoice) {
        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("courses.txt");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            System.out.println("Enter course code for change");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(";")[0].equals(input)) {
                    System.out.println("Enter new parameter:");
                    List<String> splited = Arrays.asList(line.split(";"));
                    Scanner sc1 = new Scanner(System.in);
                    String courseInput = sc1.nextLine();
                    splited.set(lecturerChoice, courseInput);
                    line = splited.stream().collect(Collectors.joining(";"));
                    Login.loggedUser().setUserName(courseInput);
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

    public static void printLecturerChangeChoice() {
        System.out.println("1. Change Course Title");
        System.out.println("2. Change Course Description");
        System.out.println("3. Change Course Start Date");
        System.out.println("4. Change Course Credit");
        System.out.println("5. Return");
    }


}

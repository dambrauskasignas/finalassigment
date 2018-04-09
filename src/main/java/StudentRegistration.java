import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRegistration {
    private static String input;

    public static String enterCourseNameToEnroll() {
        System.out.println("Enter course code to enroll");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        getCourseStartDate(input);
        return input;

    }

    public static void validatedCourseEnrollemnt(String startdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");
        int today = Integer.parseInt(LocalDate.now().format(formatter));
        int intstartDate = Integer.parseInt(startdate);
        if (today > intstartDate) {
            enrollCourse(input);
        } else {
            System.out.println("you can not enroll this course");
        }
    }

    public static void getCourseStartDate(String input) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("courses.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                if (split[0].equals(input)) {
                    validatedCourseEnrollemnt(split[3]);
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

    public static void enrollCourse(String input) {
        List<String> courseProperties = new ArrayList<>();
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("StudentInCourses.txt", true))
        ) {
            courseProperties.add(0, Login.loggedUser().getUserName());
            courseProperties.add(1, input);
            bufferedWriter.newLine();
            bufferedWriter.write(String.join(";", courseProperties));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getEnrolledCoursesList() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("StudentInCourses.txt"))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                if (split[0].equals(Login.loggedUser().getUserName())) {
                    String enrolledCourseList = split[1];
                    System.out.println(enrolledCourseList);
                }
                line = bufferedReader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getEnrolledStudentList() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("StudentInCourses.txt"))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                if (split[1].equals(Login.loggedUser().getUserName())) {
                    String enrolledCourseList = split[1];
                    System.out.println(enrolledCourseList);
                }
                line = bufferedReader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

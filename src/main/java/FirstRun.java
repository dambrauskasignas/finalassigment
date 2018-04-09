import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstRun {

    public static void FirstProgramRun() {
        addUserPropertiesNames();
        addAdminProperties();
        addCoursesPropertiesNames();
        prepareStudentAndCourseRelationshipsManagement();
    }


    public static void addUserPropertiesNames() {

        List<String> userPropertiesList = new ArrayList<>();
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt",true))
        ) {
            for (UserProperties dir : UserProperties.values()) {
                userPropertiesList.add(String.valueOf(dir));

            }
            bufferedWriter.write(String.join(";", userPropertiesList));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addAdminProperties() {
        List<String> firstUserProperties = new ArrayList<>();
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt", true))

        ) {
            bufferedWriter.newLine();
            for (UserProperties dir : UserProperties.values()) {
                firstUserProperties.add("admin");
            }

            bufferedWriter.write(String.join(";", firstUserProperties));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addCoursesPropertiesNames() {

        List<String> courseProperties = new ArrayList<>();
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Courses.txt",true))
        ) {
            for (CourseProperties dir : CourseProperties.values()) {
                courseProperties.add(String.valueOf(dir));
            }
            bufferedWriter.write(String.join(";", courseProperties));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void prepareStudentAndCourseRelationshipsManagement() {
        List<String> fileproperties = new ArrayList<>();
        String[] filepropertiesNames = {"StudentUserName", "CourseID"};
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("StudentInCourses.txt",true))
        ) {
            for (int i = 0; i < filepropertiesNames.length; i++) {
                fileproperties.add(filepropertiesNames[i]);
            }
            bufferedWriter.write(String.join(";", fileproperties));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

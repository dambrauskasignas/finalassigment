import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FirstRun {
    public static void AddUserPropertiesNames() {
        List<String> userProperties = new ArrayList<>();
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users2.txt", true))
        ) {
            for (int i = 0; i < 13; i++)
            {

                userProperties.add(String.valueOf(i));
            }
            bufferedWriter.newLine();
            bufferedWriter.write(String.join(";", userProperties));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

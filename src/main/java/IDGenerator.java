import java.util.Random;

public class IDGenerator {
    public static int CourseIDGenerator() {
        Random rand = new Random();
        int value = rand.nextInt(999999);
        return value;
    }
}

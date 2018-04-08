import java.util.Scanner;

public class Main {
    private static boolean runProgram = true;

    public static void main(String[] args) {
        boolean isloggedIn=Login.run();
        if (isloggedIn) {
            do {
                AdminPanel.printAdminMenu();
                AdminPanel.adminMenu();
            } while (runProgram);
        }
    }
}




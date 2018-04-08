import java.util.Scanner;

public class Login {

        public static boolean run() {
            String user = "admin";
            String pass = "admin";

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user ID");
            String inpUser = sc.nextLine();
            System.out.println("Enter user Pass");
            String inpPass = sc.nextLine();


            if (inpUser.equals(user) && inpPass.equals(pass)) {
                System.out.println("Hello, " + user);
                return true;
            } else {
                System.out.print("This user does not exists");
                return false;
            }
        }

}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Login.run();
    }

    public static class Login {

        public static void run() {
            String user = "admin";
            String pass = "admin";

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user ID");
            String inpUser = sc.nextLine();
            System.out.println("Enter user Pass");
            String inpPass = sc.nextLine();


            if (inpUser.equals(user) && inpPass.equals(pass)) {
                System.out.println("Hello, "+ user);
            } else {
                System.out.print("This user does not exists");
            }
        }
    }

}

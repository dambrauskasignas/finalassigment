public class Main {
    private static boolean runProgram = true;

    public static void main(String[] args) {
       FirstRun.FirstProgramRun();
        boolean isloggedIn = Login.run();
        if (isloggedIn) {
            do {
                Login.roleSelector();
            } while (runProgram);
        }
    }
}



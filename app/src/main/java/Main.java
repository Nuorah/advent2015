import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Euler euler = Euler.getInstance();

        if (args.length != 0) {
            switch (args[0]) {
                case "1" -> euler.problem1();
                case "2" -> euler.problem2();
                case "3" -> euler.problem3();
                case "4" -> euler.problem4();
                case "5" -> euler.problem5();
                case "6" -> euler.problem6();
                case "7" -> euler.problem7();
                case "8" -> euler.problem8();
                case "9" -> euler.problem9();
                default -> System.out.println("Problem not implemented");
            }
        } else {
            System.out.println("No arguments???! wtf?");
        }
    }


}
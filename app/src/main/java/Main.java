public class Main {
    public static void main(String[] args) {

        Advent2015 advent2015 = Advent2015.getInstance();

        if (args.length != 0) {
            switch (args[0]) {
                case "1" -> advent2015.day1();
                case "2" -> advent2015.day2();
                case "3" -> advent2015.day3();
                case "4" -> advent2015.day4();
                default -> System.out.println("Problem not implemented");
            }
        } else {
            System.out.println("No arguments???! wtf?");
        }
    }


}
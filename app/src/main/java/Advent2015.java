import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;



public final class Advent2015 {

    private static Advent2015 instance;
    public static Advent2015 getInstance() {
        if (instance == null) {
            instance = new Advent2015();
        }
        return instance;
    }

    public static Utils utils = Utils.getInstance();

    public static void day1() {
        int result = 0;
        int counter = 0;
        boolean isPassedByFloorMinusOne = false;
        String[] input = utils.readFile(
                Thread.currentThread()
                        .getContextClassLoader()
                        .getResource("day1/input")
                        .getPath()).split("");

        for (String c: input) {
            switch (c) {
                case ")" -> result--;
                case "(" -> result ++;
                default -> {}
            }

            if (result != -1 && !isPassedByFloorMinusOne) {
                counter ++;
            } else {
                isPassedByFloorMinusOne = true;
            }
        }

        System.out.println("Result of day 1::" + result + "::" + (counter + 1));
    }

    public static void day2() {
        String[] input = Arrays.stream(utils.readFile(
                Thread.currentThread()
                        .getContextClassLoader()
                        .getResource("day2/input")
                        .getPath()).split("\n")).toArray(String[]::new);

        int[][] cutInput = Arrays.stream(input).map(a -> Arrays.stream(a.split("x")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        double result = Arrays.stream(cutInput).map(a -> utils.wrapperSize(a[0], a[1], a[2])).reduce(Integer::sum).orElse(0);
        double result2 = Arrays.stream(cutInput).map(a -> utils.ribbonSize(a[0], a[1], a[2])).reduce(Integer::sum).orElse(0);
        System.out.println(result2);
        System.out.println(result);
    }

    public static void day3() {

        class Position{
            public int x = 0;
            public int y = 0;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Position position)) return false;
                return x == position.x && y == position.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        };

        String[] input = Arrays.stream(utils.readFile(
                Thread.currentThread()
                        .getContextClassLoader()
                        .getResource("day3/input")
                        .getPath()).split("")).toArray(String[]::new);
        int xSanta = 0;
        int ySanta = 0;
        int xRobot = 0;
        int yRobot = 0;
        int turn = 0;
        HashSet<Position> visitedHouses = new HashSet<>();
        visitedHouses.add(new Position(0, 0));
        for (String c: input) {
            Position newPosition;
            switch(c) {
                case ">" -> {
                    if (turn%2 == 0) xSanta++; else xRobot++;
                }
                case "<" -> {
                    if (turn%2 == 0) xSanta--; else xRobot--;
                }
                case "^" -> {
                    if (turn%2 == 0) ySanta++; else yRobot++;
                }
                case "v" -> {
                    if (turn%2 == 0) ySanta--; else yRobot--;
                }
            }
            turn++;
            {
                if (turn%2 == 0) {
                    visitedHouses.add(new Position(xSanta, ySanta));
                } else {
                    visitedHouses.add(new Position(xRobot, yRobot));;
                }
            }
            //System.out.println(Arrays.deepToString(visitedHouses.toArray()));

        }
        System.out.println(visitedHouses.size());
    }
    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
    public static String bytesToHex(byte[] bytes) {
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }
    public static void day4() {
        String result = "xxxxxx";
        String input = "ckczppom";
        int i = 0;
        try {
            String newInput = "";

            while(!result.startsWith("000000")) {
                newInput = input+i;
                byte[] bytesOfMessage = newInput.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                result = bytesToHex(md.digest(newInput.getBytes()));
                i++;
            }


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("result::" + result);
        System.out.println("result::" + (i - 1));

    }




}
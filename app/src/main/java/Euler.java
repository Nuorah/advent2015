import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public final class Euler {

    private static Euler instance;
    public static Euler getInstance() {
        if (instance == null) {
            instance = new Euler();
        }
        return instance;
    }

    public static Utils utils = Utils.getInstance();

    static void problem1() {
        int result = IntStream.range(0, 1000).filter(i -> i%3 == 0 || i % 5 == 0).sum();
        System.out.println("Problem #1 result::" + result);
    }

    static void problem2() {
        int[] fibo = {1, 2};
        int result = 2;
        while(fibo[1] < 4000000) {
            int newTerm = fibo[0] + fibo[1];
            fibo[0] = fibo[1];
            fibo[1] = newTerm;
            if (newTerm % 2 == 0) {
                result += newTerm;
            }
        }
        System.out.println("Problem #2 result::" + result);
    }

    static void problem3() {
        System.out.println("truc");
        long param = 600851475143L;

        long result = 0L;

        loop1:
        for (long i = (long)Math.sqrt(param); i > 1L ; i--) {
            //System.out.println(i);
            if (param % i == 0 && utils.isPrime(i)) {
                result = i;
                System.out.println(result);
                utils.addPrime(i);
                break loop1;
            }
        }
        System.out.println("Problem #3 result::" + result);
    }

    static void problem4() {
        long result = 0;
        for (int i = 999; i > 99 ; i--) {
            for (int j = 999; j > 99 ; j--) {
                if (utils.isPalindrome(i*j)) {
                    result = Math.max(result, i*j);
                }
            }

        }
        System.out.println("Probleme #4 result::" + result);
    }

    static void problem5() {
        long result = 0;
        long param = 20;

        long[] nums = LongStream.range(2,20).toArray();

        long num = Arrays.stream(nums).reduce((a, b) -> a*b).orElse(0);

        for (long i : nums) {
            while(utils.isDivisibleByAll(num, nums)) {
                System.out.println(num);
                num = num / i;
            }
            if (!utils.isDivisibleByAll(num, nums)) {
                num = num*i;
            }
        }

        result = num;
        System.out.println("Problem #5 result::" + result);
    }

    static void problem6() {
        int result = 0;
        int param = 100;

        for (int i = 0; i <= param ; i++) {
            for (int j = 0; j <= param ; j++) {
                if(i!=j) {
                    result += i*j;
                }
            }
        }
        System.out.println("Problem #4 result::" + result);
    }

    void problem7() {
        long result = 0;
        long i = 2;

        while(utils.getPrimes().size() < 10001) {
            //System.out.println(i);
            if(utils.isPrime(i)) {
                utils.addPrime(i);
                result = i;
            }
            i++;
        }
        System.out.println("Problem #7 result::" + result);
    }

    void problem8() {
        long result = 1;
        long[] param = Arrays.stream("""
                73167176531330624919225119674426574742355349194934
                96983520312774506326239578318016984801869478851843
                85861560789112949495459501737958331952853208805511
                12540698747158523863050715693290963295227443043557
                66896648950445244523161731856403098711121722383113
                62229893423380308135336276614282806444486645238749
                30358907296290491560440772390713810515859307960866
                70172427121883998797908792274921901699720888093776
                65727333001053367881220235421809751254540594752243
                52584907711670556013604839586446706324415722155397
                53697817977846174064955149290862569321978468622482
                83972241375657056057490261407972968652414535100474
                82166370484403199890008895243450658541227588666881
                16427171479924442928230863465674813919123162824586
                17866458359124566529476545682848912883142607690042
                24219022671055626321111109370544217506941658960408
                07198403850962455444362981230987879927244284909188
                84580156166097919133875499200524063689912560717606
                05886116467109405077541002256983155200055935729725
                71636269561882670428252483600823257530420752963450"""
                .replace("\n", "")
                .replace("\r", "")
                .split(""))
                .map(Long::parseLong)
                .mapToLong(x -> x)
                .toArray();
        System.out.println(Arrays.toString(param));
        for (int i = 0; i < param.length-12; i++) {
            //System.out.println(Arrays.stream(param, i, i+12).reduce((a, b) -> a*b).orElse(0));
            result = Math.max(result, Arrays.stream(param, i, i+13).reduce((a, b) -> a*b).orElse(0L));
        }

        System.out.println("Problem #8 result::" + result);

    }

    void problem9() {
        int result = 0;
        for (int a = 0; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                for (int c = b + 1; c < 1000; c++) {
                    if(a*a + b*b == c*c && a + b +c == 1000) {
                        result = a*b*c;
                    }
                }
            }

        }
        System.out.println("Problem #9 result::" + result);

    }




}
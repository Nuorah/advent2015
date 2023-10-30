import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Utils {
    private static Utils instance;

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public static HashSet<Long> primes;

    public HashSet<Long> getPrimes() {
        if (primes == null) {
            primes = new HashSet<>();
        }
        return primes;
    }

    public void addPrime(long n) {
        if (primes == null) {
            primes = new HashSet<>();
        }
        primes.add(n);
    }

    public boolean isPrime(long n) {
        if (n != 2 && !getPrimes().contains(n)) {
            for (long i = 2; i < Math.sqrt(n) + 1; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        //System.out.println(getPrimes());
        return true;
    }
    
    public boolean isDivisibleByAll(long n, long[] nums) {
        for (long i: nums) {
            if (n%i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(long n) {
        return new StringBuilder(Long.toString(n)).reverse().toString().equals(Long.toString(n));
    }

    public String readFile(String path) {
        if (path != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                return reader.lines().collect(Collectors.joining("\n"));
            } catch (Exception e) {
                System.err.println("Error while reading the file::" + e.getMessage());
            }
        }
        return "";
    }

    public int wrapperSize(int l, int w, int h) {
        return 2*(l*w + l*h + w*h) + Math.min(l*w, Math.min(w*h, l*h));
    }

    public int ribbonSize(int l, int w, int h) {
        return l*w*h + 2*(l + w + h - Math.max(l, Math.max(w, h)));
    }
}
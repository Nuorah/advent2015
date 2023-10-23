import java.util.HashSet;

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
}
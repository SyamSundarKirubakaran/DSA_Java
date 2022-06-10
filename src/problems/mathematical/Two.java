package problems.mathematical;

/**
 * @author SYAM K
 * @problem : Print prime upto n - Sieve of Eratosthenes Algorithm
 * https://www.geeksforgeeks.org/sieve-of-eratosthenes/
 */
public class Two {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        printPrime(50);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void printPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}

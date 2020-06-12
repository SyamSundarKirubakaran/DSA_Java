package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Implement pow()
 */
public class Three {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(power(2, 5));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int power(int x, int n) {
        int temp;
        if (n == 0) {
            return 1;
        }
        temp = power(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

}

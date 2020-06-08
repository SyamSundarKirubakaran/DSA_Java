package problems.dp;

/**
 * @author SYAM K
 * @problem : Sum of all digits from 1 to n
 */
public class TwentyThree {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        sumOfDigits(144);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static void sumOfDigits(int n) {
        int d = (int) Math.log10(n);
        int[] a = new int[d + 1];
        a[0] = 0;
        a[d] = 45;
        for (int i = 2; i <= d; i++) {
            a[i] = a[i - 1] * 10 + 45 * (int) Math.ceil(Math.pow(10, i - 1));
        }
        int result = util(n, a);
        System.out.println(result);
    }

    private static int util(int n, int[] a) {
        if (n < 10) {
            return (n * (n + 1)) / 2;
        }

        int d = (int) Math.log10(n);
        int p = (int) Math.ceil(Math.pow(10, d));
        int msd = n / p;
        return (msd * a[d] + ((msd - 1) * (msd - 1 + 1) / 2) * p +
                msd * (1 + n % p) + util(n % p, a));
    }

}

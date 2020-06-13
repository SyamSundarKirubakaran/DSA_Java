package problems.bits;

/**
 * @author SYAM K
 * @problem : clear Kth bit of a number
 */
public class Three {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(perform(4, 2));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int perform(int n, int k) {
        return (~(1 << k) & n);
    }

}

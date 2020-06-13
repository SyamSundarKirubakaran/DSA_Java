package problems.bits;

/**
 * @author SYAM K
 * @problem : power of 2 or not
 */
public class Six {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(check(16));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static boolean check(int x) {
        return x != 0 && ((x & (x - 1)) == 0);
    }

}

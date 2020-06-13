package problems.bits;

/**
 * @author SYAM K
 * @problem : Multiply with 7 without using `*`
 */
public class Nine {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(multipleOf7(4));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int multipleOf7(int n) {
        return ((n << 3) - n);
    }

}

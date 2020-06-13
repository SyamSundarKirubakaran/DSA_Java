package problems.bits;

/**
 * @author SYAM K
 * @problem : count the no.of set bits of a number
 */
public class Five {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(count(3));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int count(int i) {
        int count = 0;
        while (i != 0) {
            count += i & 1;
            i >>= 1;
        }
        return count;
    }

}

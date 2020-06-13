package problems.mathematical;

/**
 * @author SYAM K
 * @problem : Lucky number or not
 */
public class Three {

    private static int count = 2; // This is a bit misleading

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(lucky(7));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static boolean lucky(int n) {
        int nextPosition = n;
        if (count > n) {
            return true;
        }
        if (n % count == 0) {
            return false;
        }
        nextPosition -= nextPosition / count;
        count += 1;
        return lucky(nextPosition);
    }

}

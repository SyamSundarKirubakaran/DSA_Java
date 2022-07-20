package problems.mathematical;

/**
 * @author SYAM K
 * @problem : Lucky number or not
 */
public class Three {

    private static int count = 2; // This is a bit misleading

    public static void main(String[] args) {
        

        System.out.println(lucky(7));

        
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

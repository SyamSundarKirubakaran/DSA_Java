package problems.bits;

/**
 * @author SYAM K
 * @problem : clear Kth bit of a number
 */
public class Three {

    public static void main(String[] args) {
        

        System.out.println(perform(4, 2));

        
    }

    private static int perform(int n, int k) {
        return (~(1 << k) & n);
    }

}

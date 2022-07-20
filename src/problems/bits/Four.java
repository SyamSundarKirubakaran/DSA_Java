package problems.bits;

/**
 * @author SYAM K
 * @problem : Toggle Kth bit of a number
 */
public class Four {

    public static void main(String[] args) {


        System.out.println(perform(4, 1));


    }

    private static int perform(int n, int k) {
        return ((1 << k) ^ n);
    }

}

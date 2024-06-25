package problems.bits;

/**
 * @author SYAM K
 * @problem : set Kth Bit of a number
 */
public class B {

    public static void main(String[] args) {


        System.out.println(perform(4, 0));


    }

    private static int perform(int n, int k) {
        return ((1 << k) | n);
    }

}

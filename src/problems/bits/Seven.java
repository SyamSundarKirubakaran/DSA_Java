package problems.bits;

/**
 * @author SYAM K
 * @problem : next higher number of the given number which is a power of 2
 */
public class Seven {

    public static void main(String[] args) {


        System.out.println(nextNumber(6));
        System.out.println(nextNumber(8));


    }

    private static int nextNumber(int n) {
        int count = 0;
        while (n != 0) {
            n >>= 1;
            count += 1;
        }
        return 1 << count;
    }

}

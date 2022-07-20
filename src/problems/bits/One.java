package problems.bits;

/**
 * @author SYAM K
 * @problem : Kth bit is set or not
 */
public class One {

    public static void main(String[] args) {


        calculateLeft(5, 1);
        calculateRight(5, 1);


    }

    // using left shift
    private static void calculateLeft(int n, int k) {
        if ((n & (1 << (k - 1))) == 1) {
            System.out.println("set");
        } else {
            System.out.println("!set");
        }
    }

    // using right shift
    private static void calculateRight(int n, int k) {
        if (((n >> (k - 1)) & 1) == 1) {
            System.out.println("set");
        } else {
            System.out.println("!set");
        }
    }

}

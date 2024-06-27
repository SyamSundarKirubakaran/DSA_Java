package problems.bits;

/**
 * @author SYAM K
 * @problem : Multiply with 7 without using `*`
 */
public class I {

    public static void main(String[] args) {


        System.out.println(multipleOf7(4));


    }

    private static int multipleOf7(int n) {
        return ((n << 3) - n);
    }

}

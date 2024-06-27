package problems.bits;

/**
 * @author SYAM K
 * @problem : power of 4 or not
 */
public class H {

    public static void main(String[] args) {
        

        System.out.println(power(16));

        
    }

    private static boolean power(int n) {
        return n != 0 && ((n & (n - 1)) == 0) && (n & 0xAAAAAAAA) == 0;
    }

    // Why 0xAAAAAAAA ? This is because the bit representation is of powers of 2 that are not of 4. Like 2, 8, 32 so on..

}

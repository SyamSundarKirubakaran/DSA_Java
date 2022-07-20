package problems.bits;

/**
 * @author SYAM K
 * @problem : power of 2 or not
 */
public class Six {

    public static void main(String[] args) {
        

        System.out.println(check(16));

        
    }

    private static boolean check(int x) {
        return x != 0 && ((x & (x - 1)) == 0);
    }

}

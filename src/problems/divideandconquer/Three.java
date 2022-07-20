package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Implement pow()
 */
public class Three {

    public static void main(String[] args) {


        System.out.println(power(3, 2));

        
    }

    private static int power(int x, int n) {
        int temp;
        if (n == 0) {
            return 1;
        }
        temp = power(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

}

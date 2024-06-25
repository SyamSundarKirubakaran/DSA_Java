package generic_workout;

// https://leetcode.com/problems/divide-two-integers/

public class I {

    /**
     * Remember that we're converting the inputs to negative numbers.
     * This is because we don't want separate code for all the possible combinations of positive/negative divisor and dividend.
     * We converted them to negative instead of positive because the range of valid negative numbers is bigger, and therefore overflows can be cleanly avoided.
     * ---
     * The looping condition is while (dividend - divisor <= 0) because the difference is moving towards zero from the negative side.
     * Therefore, we want to continue while it is still under it. Once it goes over, we know we're done.
     * **/

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }


    public static int divide(int dividend, int divisor) {

        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives
         * for the reasons explained above.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        /* Count how many times the divisor has to be added
         * to get the dividend. This is the quotient. */
        int quotient = 0;
        while (dividend - divisor <= 0) {
            quotient--;
            dividend -= divisor;
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            quotient = -quotient;
        }
        return quotient;
    }

}

package workout;

// https://leetcode.com/problems/reverse-integer/

public class D {

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        if (x < 10 && x > -10) return x;

        boolean isNegative = x < 0;
        x = Math.abs(x);
        int result = 0;

        while (x > 0) {
            int d = x % 10;
            result = (result * 10) + d;
            x /= 10;
        }

        return isNegative ? -result : result;
    }

}

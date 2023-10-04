package workout.temp;


// https://leetcode.com/problems/powx-n/


class O {
    public double myPow(double x, int n) {
        return exponent(x, n);
    }

    public static double exponent(double x, int n){
        if(n == 0) return 1;
        else if(n < 0) return exponent(1/x, -n);
        else if(n % 2 == 0) return exponent(x*x, n/2);
        else return x * exponent(x*x, (n-1)/2);
    }

    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double ans = 1;
            double current_product = x;
            for (long i = N; i > 0; i /= 2) {
                if ((i % 2) == 1) {
                    ans = ans * current_product;
                }
                current_product = current_product * current_product;
            }
            return ans;
        }
    };

}
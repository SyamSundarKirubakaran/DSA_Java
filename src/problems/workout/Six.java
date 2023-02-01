package problems.workout;

public class Six {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(exponent(x, n));
    }


    public static double exponent(double x, int n){
        if(n == 0) return 1;
        else if(n < 0) return exponent(1/x, -n);
        else if(n % 2 == 0) return exponent(x*x, n/2);
        else return x * exponent(x*x, (n-1)/2);
    }
}

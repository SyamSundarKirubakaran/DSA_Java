package generic_workout.company.workout;

import java.util.HashSet;

public class Three {

    public static void main(String[] args) {
        int n = 19;

        HashSet<Integer> hSet = new HashSet<>();

        int result = 0;
        while(n != 1) {
            result = 0;
            while(n > 0){
                int digit = n % 10;
                result += Math.pow(digit, 2);
                n /= 10;
            }
            if(hSet.contains(result))
                break;
            n = result;
            hSet.add(result);
        }

        System.out.println(n == 1);
    }
}

package workout.temp;


// https://leetcode.com/problems/happy-number/

import java.util.HashSet;

class M {
    public boolean isHappy(int n) {
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

        return  n == 1;
    }
}

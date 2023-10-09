package problems.company.lucid;

// https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

import java.util.HashMap;
import java.util.Map;

class C {

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int d = digitSum(i);
            map.put(d, map.getOrDefault(d, 0) + 1);
            res = Math.max(res, map.get(d));
        }
        return res;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.countBalls(1, 10));
    }


}

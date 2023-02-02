package prep.feb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

public class C {

    public static void main(String[] args) {
        int n = 3, k = 7;

        System.out.println(Arrays.toString(numsSameConsecDiff(n, k)));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        if (n == 1)
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7};

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            DFS(n - 1, i, k, result);
        }

        int[] returnArr = new int[result.size()];

        for (int i = 0; i < returnArr.length; i++) {
            returnArr[i] = result.get(i);
        }

        return returnArr;
    }

    public static void DFS(int n, int num, int k, List<Integer> results) {
        if (n == 0) {
            results.add(num);
            return;
        }

        List<Integer> nextDigits = new ArrayList<>();

        int lastDigit = num % 10;
        nextDigits.add(lastDigit + k);
        if (k != 0)
            nextDigits.add(lastDigit - k);

        for (int digit : nextDigits) {
            if (digit >= 0 && digit < 10) {
                int newNum = num * 10 + digit; // it's `+ digit` not `+ lastDigit`
                DFS(n - 1, newNum, k, results);
            }
        }
    }

}

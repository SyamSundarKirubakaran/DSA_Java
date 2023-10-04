package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Given a string of digits, sub string length = 2k, sum of left k = sum of right k
 */
public class TwentyFour {

    public static void main(String[] args) {
        

        int[] arr = new int[]{3, 1, 2, 5, 3, 0, 8};
        split(arr, arr.length);

        
    }

    private static void split(int[] arr, int n) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i][i] = arr[i];
        }
        int j;
        for (int ls = 2; ls <= n; ls++) {
            for (int i = 0; i < n - ls + 1; i++) {
                j = i + ls - 1;
                temp[i][j] = temp[i + 1][j] + temp[i][j - (ls - 1)]; // after `+` similar to workout.temp[i][i]
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        List<Integer> obtainedValue;
        List<String> possibleResults = new ArrayList<>();
        for (int ls = 2; ls <= n; ls++) {
            for (int i = 0; i < n - ls + 1; i++) {
                j = i + ls - 1;
                if (hashMap.get(temp[i][j]) == null) {
                    hashMap.put(temp[i][j], new ArrayList<>(Arrays.asList(i, j)));
                } else {
                    obtainedValue = hashMap.get(temp[i][j]);
                    if (obtainedValue.get(1) < i) {
                        possibleResults.add("Result: (" + obtainedValue.get(0) + ", " + obtainedValue.get(1) + ") & (" + i + ", " + j + ")");
                    }
                }
            }
            hashMap.clear();
        }
        System.out.println(possibleResults.get(possibleResults.size() - 1));
    }

}

package problems.hashing;

import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Find 4 elements i, j, k & l -> such that `i + j = k + l`
 */
public class Seven {

    private static final int[] arr = new int[]{3, 4, 7, 1, 2, 9, 8};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(findPairs(arr));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static boolean findPairs(int[] arr) {
        HashMap<Integer, pair> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new pair(i, j));
                else {
                    pair p = map.get(sum);
                    System.out.println("(" + arr[p.first] + ", " + arr[p.second] +
                            ") and (" + arr[i] + ", " + arr[j] + ")");
                    return true;
                }
            }
        }
        return false;
    }

    private static class pair {
        int first, second;

        pair(int f, int s) {
            first = f;
            second = s;
        }
    }

}

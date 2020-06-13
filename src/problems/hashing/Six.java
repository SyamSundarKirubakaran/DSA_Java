package problems.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Find the no.of sub arrays with sum zero
 */
public class Six {

    private static final int[] arr = new int[]{6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(findSubArrays(arr, arr.length));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static ArrayList<Pair> findSubArrays(int[] arr, int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Pair> out = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0)
                out.add(new Pair(0, i));
            ArrayList<Integer> al = new ArrayList<>();
            if (map.containsKey(sum)) {
                al = map.get(sum);
                for (Integer integer : al) {
                    out.add(new Pair(integer + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }
        return out;
    }

    private static class Pair {
        int first, second;

        Pair(int a, int b) {
            first = a;
            second = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

}

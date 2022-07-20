package problems.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SYAM K
 * @problem : Group all occurrences of elements order by their 1st occurrence.
 */
public class Three {

    private static final int[] arr = new int[]{10, 5, 3, 10, 10, 4, 1, 3};

    public static void main(String[] args) {


        performGrouping(arr, arr.length);


    }

    private static void performGrouping(int[] arr, int length) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int value : arr) {
            hashMap.merge(value, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int count = entry.getValue();
            while (count != 0) {
                System.out.print(entry.getKey() + " ");
                count -= 1;
            }
        }
        System.out.println();
    }

}

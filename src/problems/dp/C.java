package problems.dp;

import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Longest Sub Sequence in an array such that the element are consecutive
 */
public class C {

    private static final int[] arr = new int[]{10, 4, 3, 11, 13, 5, 6, 12, 7};
    private static final HashMap<Integer, Boolean> hashMap = new HashMap<>();

    public static void main(String[] args) {
        compute(arr, arr.length);
    }

    private static void compute(int[] arr, int length) {
        fillHashMap(arr, length);
        int currentValue, count, maxCount = 0;
        for (int i = 0; i < length; i++) {
            currentValue = arr[i];
            count = 0;
            while (hashMap.get(currentValue - 1) != null &&
                    !hashMap.get(currentValue - 1)) {
                hashMap.put(currentValue - 1, true);
                currentValue -= 1;
                count += 1;
            }
            while (hashMap.get(currentValue + 1) != null &&
                    !hashMap.get(currentValue + 1)) {
                hashMap.put(currentValue + 1, true);
                currentValue += 1;
                count += 1;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);
    }

    private static void fillHashMap(int[] arr, int length) {
        for (int value : arr) {
            hashMap.put(value, false);
        }
    }

}

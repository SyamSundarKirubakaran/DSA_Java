package problems.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Largest sub array with equal no.of zeros and ones
 */
public class TwentyTwo {

    private static int[] arr = new int[]{0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0};

    public static void main(String[] args) {
        findMaxSubArray(arr, arr.length - 1);
    }

    private static void findMaxSubArray(int[] arr, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSize = Integer.MIN_VALUE, startIndex = 0, sum = 0;
        arr = Arrays.stream(arr).map(entry -> entry == 0 ? -1 : 1).toArray();
        for (int i = 0; i <= size; i++) {
            sum += arr[i];
            if (arr[i] == 0) {
                startIndex = 0;
                maxSize = i;
                continue;
            }
            if (map.get(sum) != null) {
                if (i - map.get(sum) > maxSize) {
                    maxSize = i - map.get(sum);
                    startIndex = map.get(sum);
                }
            }
            map.put(sum, i);
        }
        if (maxSize == Integer.MIN_VALUE) {
            System.out.println("No Such sub array");
        } else {
            System.out.println("Sub array from " + (startIndex) + " to " + (maxSize + 1));
        }
    }

}

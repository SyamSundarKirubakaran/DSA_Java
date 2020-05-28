package problems.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Largest sub array with equal no.of zeros and ones - my way
 */
public class ThirtyEight {

    private static int[] arr = new int[]{0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0};

    public static void main(String[] args) {
        findSubArray(arr, arr.length);
    }

    private static void findSubArray(int[] arr, int size) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int end = -1;
        int start = -1;
        arr = Arrays.stream(arr).map(entry -> entry == 0 ? -1 : 1).toArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer pull;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            pull = map.get(sum);
            if (arr[i] == 0) {
                // This never happens because replaced with -1
                if ((i - i) > max) {
                    max = (i - i);
                    start = i;
                    end = i;
                }
            } else if (sum == 0) {
                if ((i - 0) > max) {
                    max = i - 0;
                    start = 0;
                    end = i;
                }
            } else if (pull != null) {
                if ((i - (pull + 1)) > max) {
                    max = i - (pull + 1);
                    start = pull + 1;
                    end = i;
                }
            }
            map.put(sum, i);
        }
        System.out.println(start + " - " + end);
    }

}

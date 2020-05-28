package problems.array;

import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Find Sub Array whose sum is equals zero - reduced time complexity
 */
public class ThirtySeven {

    private static int[] arr = new int[]{8, -2, -3, -4, 5, 4};

    public static void main(String[] args) {
        isPresent(arr, arr.length);
    }

    private static void isPresent(int[] arr, int length) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        Integer pull;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            pull = map.get(sum);
            if (pull != null)
                System.out.print((pull + 1) + " " + i);
            else if (sum == 0)
                System.out.print(0 + " " + i);
            else
                System.out.print(i + " " + i);
            map.put(sum, i);
        }
    }

}

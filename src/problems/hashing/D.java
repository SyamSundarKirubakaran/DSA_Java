package problems.hashing;

import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Given an array A, count the distinct elements in all windows of size K
 */
public class D {

    private static final int[] arr = new int[]{1, 2, 1, 3, 4, 2, 3};

    public static void main(String[] args) {
        

        count(arr, arr.length, 4);

        
    }

    private static void count(int[] arr, int length, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int distCount = 0;

        for (int i = 0; i < k; i++) {
            if (hashMap.get(arr[i]) == null) {
                hashMap.put(arr[i], 1);
                distCount++;
            } else {
                int count = hashMap.get(arr[i]);
                hashMap.put(arr[i], count + 1);
            }
        }

        System.out.println(distCount);

        for (int i = k; i < length; i++) {

            if (hashMap.get(arr[i - k]) == 1) {
                hashMap.remove(arr[i - k]);
                distCount--;
            } else {
                int count = hashMap.get(arr[i - k]);
                hashMap.put(arr[i - k], count - 1);
            }

            if (hashMap.get(arr[i]) == null) {
                hashMap.put(arr[i], 1);
                distCount++;
            } else {
                int count = hashMap.get(arr[i]);
                hashMap.put(arr[i], count + 1);
            }

            System.out.println(distCount);
        }
    }

}

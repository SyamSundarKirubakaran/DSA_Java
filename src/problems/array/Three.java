package problems.array;

import java.util.HashMap;

/**
 * @author SYAM K
 * @problem : Find a pair in an array whose sum is equal to given number (Hash Approach) - Brute Force, Quick Sort and search complement, Hash Table
 */

class Three {
    static int[] arr = new int[]{22, 33, 11, 55, 99, 77, 66, 88};
    static HashMap<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        findPairs(arr, 143);
    }

    static void findPairs(int[] arr, int sum) {
        inflateInHash(arr);
        int complement;
        for (int value : arr) {
            complement = sum - value;
            if (map.get(complement) != null && map.get(complement)) {
                System.out.println("Values: " + value + " & " + complement);
                return;
            }
        }
    }

    static void inflateInHash(int[] arr) {
        for (int value : arr) {
            map.put(value, true);
        }
    }
}
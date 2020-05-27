package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : 3 elements such that their sum is equal to x.
 */

class Thirteen {
    static int[] arr = new int[]{1, 2, 5, 6, 9, 10};

    public static void main(String[] args) {
        findTriplet(arr, 0, arr.length - 1, arr.length - 1, 15);
    }

    static void findTriplet(int[] arr, int left, int right, int size, int key) {
        int sum;
        int req_index_one = -1, req_index_two = -1, req_index_three = -1;
        Arrays.sort(arr);
        label:
        for (int i = 0; i <= size; i++) {
            req_index_one = i;
            while (left < right) {
                sum = arr[i] + arr[left] + arr[right];
                if (sum == key) {
                    req_index_two = left;
                    req_index_three = right;
                    break label;
                } else if (sum < key) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        if (req_index_three != -1) {
            System.out.println("Elements to get a sum of " + key + " are: " +
                    arr[req_index_one] + ", " +
                    arr[req_index_two] + " & " +
                    arr[req_index_three]);
        } else {
            System.out.println("Not found");
        }
    }
}
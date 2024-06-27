package problems.array;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : No.of Triangles that can be formed
 */
public class ZF {
    private static int[] arr = new int[]{6, 7, 10, 8, 14, 12, 50};

    public static void main(String[] args) {
        int result = findNoOfTriangles(arr, arr.length - 1);
        System.out.println(result);
    }

    private static int findNoOfTriangles(int[] arr, int size) {
        Arrays.sort(arr);
        int counter = 0, j, k;
        for (int i = 0; i <= size - 2; i++) {
            j = i + 1;
            k = j + 1;
            while (j <= size - 1) {
                while (arr[i] + arr[j] > arr[k]) {
                    counter += 1;
                    k++;
                }
                j++;
                k = j + 1;
            }
        }
        return counter;
    }


}

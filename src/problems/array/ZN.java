package problems.array;

/**
 * @author SYAM K
 * @problem : Rotate an array of size n by d elements - Left rotation - Beginning to End
 */
public class ZN {

    private static final int[] arr = new int[]{1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        

        rotateByK(arr, 2, arr.length);

        
    }

    private static void rotateByK(int[] arr, int k, int size) {
        performRotation(arr, 0, k - 1);
        performRotation(arr, k, size - 1);
        performRotation(arr, 0, size - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void performRotation(int[] arr, int left, int right) {
        int temp;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 1;
            right -= 1;
        }
    }

}

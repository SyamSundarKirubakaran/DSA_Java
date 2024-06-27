package problems.heaps;

/**
 * @author SYAM K
 * @problem : Check if the given binary tree is a max heap or not.
 */
public class N {

    public static void main(String[] args) {


        int[] arr = {90, 15, 10, 7, 12, 2, 7, 3};
        int n = arr.length - 1;
        if (isHeap(arr, 0, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }

    static boolean isHeap(int[] arr, int i, int n) {
        if (i > (n - 2) / 2) // If a leaf node
            return true;

        // If an internal node and is greater than its children, and
        // same is recursively true for the children
        return arr[i] >= arr[2 * i + 1] && arr[i] >= arr[2 * i + 2]
                && isHeap(arr, 2 * i + 1, n) && isHeap(arr, 2 * i + 2, n);
    }

    static boolean isHeapIterative(int[] arr, int n) {
        // Start from root and go till the last internal node
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // If left child is greater, return false
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }

            // If right child is greater, return false
            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }

}

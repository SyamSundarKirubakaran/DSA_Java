package problems.array;

/**
 * @author SYAM K
 * @problem : Separate 0's and 1's in an array
 */

public class J {

    static int[] arr = new int[]{1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0};

    public static void main(String[] args) {
        seperateZeroAndOne(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void seperateZeroAndOne(int[] arr, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            while (arr[leftPointer] == 0 && leftPointer < rightPointer)
                leftPointer++;
            while (arr[rightPointer] == 1 && leftPointer < rightPointer)
                rightPointer--;
            if (leftPointer < rightPointer) {
                swap(leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }
    }

    private static void swap(int left, int right) {
        arr[left] = 0;
        arr[right] = 1;
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
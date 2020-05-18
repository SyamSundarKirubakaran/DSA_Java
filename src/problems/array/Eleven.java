package problems.array;

/**
 * @author SYAM K
 * @problem : Separate Even and Odd numbers in an array
 */

class Eleven {
    static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        performSeperation(arr, 0, arr.length - 1);
        printArray(arr);
    }

    static void performSeperation(int[] arr, int left, int right) {
        while (left < right) {
            while (arr[left] % 2 != 0 && left < right)
                left++;
            while (arr[right] % 2 == 0 && left < right)
                right--;
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
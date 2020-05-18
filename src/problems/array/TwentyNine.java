package problems.array;

/**
 * @author SYAM K
 * @problem : Sort array in wave form - Even position number
 */
public class TwentyNine {

    private static int[] arr = new int[]{1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        sortArrayInWareForm(arr, arr.length - 1);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void sortArrayInWareForm(int[] arr, int size) {
        for (int i = 0; i <= size; i += 2) {
            if (i > 0 && arr[i - 1] > arr[i])
                swap(arr, i, i - 1);
            if (i < size && arr[i] < arr[i + 1])
                swap(arr, i, i + 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

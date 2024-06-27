package problems.array;

/**
 * @author SYAM K
 * @problem : Sort array in wave form - Even position number
 */
public class ZC {

    private static final int[] arr = new int[]{1, 50, 50, 70, 5, 1};
    private static final int[] arr1 = new int[]{10, 9, 8, 7, 6, 5};

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
            if (i > 0 && arr[i - 1] > arr[i]) {
                printArray(arr);
                System.out.println("I. Swapped: " + arr[i - 1] + " > " + arr[i] + ", Index: " + (i - 1) + " & " + i);
                swap(arr, i, i - 1);
                printArray(arr);
            }
            if (i < size && arr[i] < arr[i + 1]) {
                printArray(arr);
                System.out.println("II. Swapped: " + arr[i] + " < " + arr[i + 1] + ", Index: " + i + " & " + (i + 1));
                swap(arr, i, i + 1);
                printArray(arr);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

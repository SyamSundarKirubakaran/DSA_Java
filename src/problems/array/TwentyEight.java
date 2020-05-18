package problems.array;

/**
 * @author SYAM K
 * @problem : Rotate an array of size n by d elements - Left rotation - Beginning to End - Juggling Algorithm
 */
public class TwentyEight {
    private static int[] arr = new int[]{1, 2, 3, 4, 5};

    public static void main(String[] args) {
        performLeftRotation(arr, arr.length - 1, 2); // size is the actual array size and not the last index
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void performLeftRotation(int[] arr, int size, int d) {
        int index1, index2, index3, temp;
        for (index1 = 0; index1 < gcd(size + 1, d); index1++) { // size + 1 -> actual length of the array
            temp = arr[index1];
            index2 = index1;
            while (true) {
                index3 = index2 + d;
                if (index3 > size)
                    index3 -= (size + 1); // size + 1 -> actual length of the array
                if (index1 == index3)
                    break;
                arr[index2] = arr[index3];
                index2 = index3;
            }
            arr[index2] = temp;
        }
    }

    private static int gcd(int size, int d) {
        return (d == 0) ? size : gcd(d, (size % d));
    }


}

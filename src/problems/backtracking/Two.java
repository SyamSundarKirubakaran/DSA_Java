package problems.backtracking;

/**
 * @author SYAM K
 * @problem : Print all the strings of n-bits
 */
public class Two {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        int n = 4;
        int[] arr = new int[n];
        generateAllBinaryStrings(n, arr, 0);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static void printTheArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void generateAllBinaryStrings(int n, int[] arr, int i) {
        if (i == n) {
            printTheArray(arr, n);
            return;
        }

        arr[i] = 0;
        generateAllBinaryStrings(n, arr, i + 1);

        arr[i] = 1;
        generateAllBinaryStrings(n, arr, i + 1);
    }

}

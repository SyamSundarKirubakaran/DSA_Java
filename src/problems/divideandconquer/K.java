package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : search for an element in a row-wise and column-wise sorted 2d array.
 */
public class K {

    private static final int[][] arr = new int[][]{
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
    };

    public static void main(String[] args) {
        

        search(arr, arr.length, 37);

        
    }

    private static void search(int[][] arr, int n, int x) {
        int i = 0, j = n - 1;
        while (i < n && j >= 0) {
            if (arr[i][j] == x) {
                System.out.println("(" + i + ", " + j + ")");
                return;
            }
            if (x < arr[i][j]) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        System.out.println("Element can't be found");
    }

}

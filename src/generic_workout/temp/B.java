package generic_workout.temp;


// https://leetcode.com/problems/image-overlap/

public class B {

    public static void main(String[] args) {
        int[][] img1 = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };

        int[][] img2 = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        };

//        int[][] img1 = new int[][]{
//                {1}
//        };
//
//        int[][] img2 = new int[][]{
//                {1}
//        };

        System.out.println(largestOverlap(img1, img2));
    }

    public static int largestOverlap(int[][] a, int[][] b) {

        int n = b.length; // both are of same size doesn't matter if it's a.length are b.length

        int[][] paddedb = new int[n + 2 * (n - 1)][n + 2 * (n - 1)];

        // printMatrix(paddedb);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paddedb[i + n - 1][j + n - 1] = b[i][j];
            }
        }

        printMatrix(paddedb);

        int result = 0;
        for (int i = 0; i < 2 * n - 1; i++) { // mistake here: not 2*(n-1)
            for (int j = 0; j < 2 * n - 1; j++) {
                result = Math.max(result, convolute(a, paddedb, i, j));
            }
        }

        return result;
    }

    public static int convolute(int[][] a, int[][] paddedb, int xShift, int yShift) {

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                result+=(a[i][j]*paddedb[xShift+i][yShift+j]);
            }
        }

        return result;
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }


}

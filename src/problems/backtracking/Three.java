package problems.backtracking;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : N-Queens Problem
 */
public class Three {

    static int N = 4;
    /* ld is an array where its indices indicate row-col+N-1
        (N-1) is for shifting the difference to store negative
        indices */
    static int[] ld = new int[10];
    /* rd is an array where its indices indicate row+col
        and used to check whether a queen can be placed on
        right diagonal or not*/
    static int[] rd = new int[10];
    /*column array where its indices indicates column and
        used to check whether a queen can be placed in that
        row or not*/
    static int[] cl = new int[10];

    public static void main(String[] args) {
        

        solveNQ();


    }

    static boolean solveNQUtil(int[][] board, int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if ((ld[i - col + N - 1] != 1 && rd[i + col] != 1) && cl[i] != 1) {
                board[i][col] = 1;
                ld[i - col + N - 1] = rd[i + col] = cl[i] = 1;

                System.out.println("row*: " + i + ", col*: " + col + ", ld*: " + (i - col + N - 1) + ", rd*: " + (i + col) + ", cl*: " + i);
                System.out.println("ld: " + Arrays.toString(ld));
                System.out.println("rd: " + Arrays.toString(rd));
                System.out.println("cl: " + Arrays.toString(cl));
                System.out.println("Before");
                printSolution(board);

                if (solveNQUtil(board, col + 1))
                    return true;

                System.out.println("row*: " + i + ", col*: " + col + ", ld: " + (i - col + N - 1) + ", rd: " + (i + col) + ", cl: " + i);
                System.out.println("ld: " + Arrays.toString(ld));
                System.out.println("rd: " + Arrays.toString(rd));
                System.out.println("cl: " + Arrays.toString(cl));
                System.out.println("After");
                printSolution(board);

                board[i][col] = 0;
                ld[i - col + N - 1] = rd[i + col] = cl[i] = 0;
            } else {
                System.out.println("----------------");
                System.out.println("Skipped: row*: " + i + ", col*: " + col + ", ld: " + (i - col + N - 1) + ", rd: " + (i + col) + ", cl: " + i);
                System.out.println("ld: " + Arrays.toString(ld));
                System.out.println("rd: " + Arrays.toString(rd));
                System.out.println("cl: " + Arrays.toString(cl));
                System.out.println("----------------");
            }
        }

        return false;
    }

    static void solveNQ() {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return;
        }

        printSolution(board);
    }

    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf(" %d ", board[i][j]);
            System.out.print("\n");
        }
        System.out.println("-------------");
    }
}

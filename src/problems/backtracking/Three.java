package problems.backtracking;

/**
 * @author SYAM K
 * @problem : N-Queens Problem
 */
public class Three {

    static int N = 4;
    static int[] ld = new int[30];
    static int[] rd = new int[30];
    static int[] cl = new int[30];

    public static void main(String[] args) {
        Long start = System.nanoTime();

        solveNQ();

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf(" %d ", board[i][j]);
            System.out.print("\n");
        }
    }

    static boolean solveNQUtil(int[][] board, int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if ((ld[i - col + N - 1] != 1 &&
                    rd[i + col] != 1) && cl[i] != 1) {
                board[i][col] = 1;
                ld[i - col + N - 1] =
                        rd[i + col] = cl[i] = 1;

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0;
                ld[i - col + N - 1] =
                        rd[i + col] = cl[i] = 0;
            }
        }


        return false;
    }

    static void solveNQ() {
        int[][] board = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return;
        }

        printSolution(board);
    }
}

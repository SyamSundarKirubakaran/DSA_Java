package problems.backtracking;

/**
 * @author SYAM K
 * @problem : Knight Tour Problem
 * @Explanation :
 * If all squares are visited
 * print the solution
 * Else
 * a) Add one of the next moves to solution vector and recursively
 * check if this move leads to a solution. (A Knight can make maximum
 * eight moves. We choose one of the 8 moves in this step).
 * b) If the move chosen in the above step doesn't lead to a solution
 * then remove this move from the solution vector and try other
 * alternative moves.
 * c) If none of the alternatives work then return false (Returning false
 * will remove the previously added item in recursion and if false is
 * returned by the initial call of recursion then "no solution exists" )
 */
public class E {

    static int N = 8;

    public static void main(String[] args) {
        

        solveKT();

        
    }

    static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static void solveKT() {
        int[][] sol = new int[8][8];

        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0] = 0;

        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
        } else
            printSolution(sol);

    }

    static boolean solveKTUtil(int x,
                               int y,
                               int movei,
                               int[][] sol,
                               int[] xMove,
                               int[] yMove) {
        int k, nextX, nextY;
        if (movei == N * N)
            return true;

        for (k = 0; k < 8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(nextX, nextY, sol)) {
                sol[nextX][nextY] = movei;
                if (solveKTUtil(
                        nextX,
                        nextY,
                        movei + 1,
                        sol,
                        xMove,
                        yMove))
                    return true;
                else
                    sol[nextX][nextY] = -1; // backtrack
            }
        }

        return false;
    }

    static void printSolution(int[][] sol) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

}

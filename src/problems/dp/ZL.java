package problems.dp;

/**
 * @author SYAM K
 * @problem : Max points in the grid using 2 traversals
 */
public class ZL {

    private static final int ROWS = 5;
    private static final int COLS = 5;

    private static final int[][] coins = new int[][]{
            {3, 5, 7, 3, 2},
            {6, 7, 2, 4, 6},
            {1, 20, 40, 20, 7},
            {3, 4, 1, 20, 5},
            {4, 3, 5, 2, 1}
    };


    public static void main(String[] args) {
        

        System.out.println(geMaxCollection(coins));

        
    }

    private static boolean isValid(int x, int y1, int y2) {
        return (x >= 0 && x < ROWS && y1 >= 0 && y1 < COLS && y2 >= 0 && y2 < COLS);
    }

    private static int max(int x, int y) {
        return (Math.max(x, y));
    }

    private static int getMaxUtil(int[][] coins, int[][][] mem, int x, int y1, int y2) {
        int answer, temp;

        if (!isValid(x, y1, y2))
            return Integer.MIN_VALUE;

        if (x == ROWS - 1 && y1 == 0 && y2 == COLS - 1)
            return (y1 == y2) ? coins[x][y1] : coins[x][y1] + coins[x][y2];

        if (x == ROWS - 1)
            return Integer.MIN_VALUE;

        if (mem[x][y1][y2] != -1)
            return mem[x][y1][y2];

        answer = Integer.MIN_VALUE;

        temp = (y1 == y2) ? coins[x][y1] : coins[x][y1] + coins[x][y2];

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1, y2 - 1));

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1, y2 + 1));

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1, y2));

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1 - 1, y2));

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1 - 1, y2 - 1));

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1 - 1, y2 + 1));

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1 + 1, y2));

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1 + 1, y2 - 1));

        answer = max(answer, temp + getMaxUtil(coins, mem, x + 1, y1 + 1, y2 + 1));

        return (mem[x][y1][y2] = answer);
    }

    private static int geMaxCollection(int[][] coins) {

        int[][][] mem = new int[ROWS][COLS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                for (int k = 0; k < COLS; k++) {
                    mem[i][j][k] = -1;
                }
            }
        }

        return getMaxUtil(coins, mem, 0, 0, COLS - 1);
    }


}

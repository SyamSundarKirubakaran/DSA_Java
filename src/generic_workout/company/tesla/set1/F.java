package generic_workout.company.tesla.set1;

// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/editorial/

public class F {

    // Initialize the board, n = 3 in this problem.
    private int[][] board;
    private int n = 3;

    public String tictactoe(int[][] moves) {
        board = new int[n][n];
        int player = 1;

        // For each move
        for (int[] move : moves) {
            int row = move[0], col = move[1];

            // Mark the current move with the current playrer's id.
            board[row][col] = player;

            // If any of the winning conditions is met, return the current player's id.
            if (checkRow(row, player) ||
                    checkCol(col, player) ||
                    (row == col && checkDiagonal(player)) ||
                    (row + col == n - 1 && checkAntiDiagonal(player))) {
                return player == 1 ? "A" : "B";
            }

            // If no one wins so far, change to the other player alternatively.
            // That is from 1 to -1, from -1 to 1.
            player *= -1;
        }

        // If all moves are completed and there is still no result, we shall check if
        // the grid is full or not. If so, the game ends with draw, otherwise pending.
        return moves.length == n * n ? "Draw" : "Pending";
    }

    // Check if any of 4 winning conditions to see if the current player has won.
    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; ++col) {
            if (board[row][col] != player) return false;
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int row = 0; row < n; ++row) {
            if (board[row][col] != player) return false;
        }
        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; ++row) {
            if (board[row][row] != player) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; ++row) {
            if (board[row][n - 1 - row] != player) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] moves = new int[][]{
                {0, 0},
                {2, 0},
                {1, 1},
                {2, 1},
                {2, 2}
        };

        System.out.println(new F().tictactoe(moves));
    }
}

class SolutionOne {
    public String tictactoe(int[][] moves) {

        // n stands for the size of the board, n = 3 for the current game.
        int n = 3;

        // Use rows and cols to record the value on each row and each column.
        // diag1 and diag2 to record value on diagonal or anti-diagonal.
        int[] rows = new int[n], cols = new int[n];
        int diag = 0, anti_diag = 0;

        // Two players having value of 1 and -1, player_1 with value = 1 places first.
        int player = 1;

        for (int[] move : moves) {

            // Get the row number and column number for this move.
            int row = move[0], col = move[1];

            // Update the row value and column value.
            rows[row] += player;
            cols[col] += player;

            // If this move is placed on diagonal or anti-diagonal,
            // we shall update the relative value as well.
            if (row == col) {
                diag += player;
            }
            if (row + col == n - 1) {
                anti_diag += player;
            }

            // Check if this move meets any of the winning conditions.
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                    Math.abs(diag) == n || Math.abs(anti_diag) == n) {
                return player == 1 ? "A" : "B";
            }

            // If no one wins so far, change to the other player alternatively.
            // That is from 1 to -1, from -1 to 1.
            player *= -1;
        }

        // If all moves are completed and there is still no result, we shall check if
        // the grid is full or not. If so, the game ends with draw, otherwise pending.
        return moves.length == n * n ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        int[][] moves = new int[][]{
                {0, 0},
                {2, 0},
                {1, 1},
                {2, 1},
                {2, 2}
        };

        System.out.println(new SolutionOne().tictactoe(moves));
    }

}

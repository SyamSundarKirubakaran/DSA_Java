package problems.company.tesla;

// https://leetcode.com/problems/design-tic-tac-toe/editorial/

class N {

    static class TicTacToe {

        private int[][] board;
        private int n;

        public TicTacToe(int n) {
            board = new int[n][n];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            board[row][col] = player;
            // check if the player wins
            if ((checkRow(row, player)) ||
                    (checkColumn(col, player)) ||
                    (row == col && checkDiagonal(player)) ||
                    (col == n - row - 1 && checkAntiDiagonal(player))) {
                return player;
            }
            // No one wins
            return 0;
        }

        private boolean checkDiagonal(int player) {
            for (int row = 0; row < n; row++) {
                if (board[row][row] != player) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkAntiDiagonal(int player) {
            for (int row = 0; row < n; row++) {
                if (board[row][n - row - 1] != player) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkColumn(int col, int player) {
            for (int row = 0; row < n; row++) {
                if (board[row][col] != player) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkRow(int row, int player) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] != player) {
                    return false;
                }
            }
            return true;
        }
    }

}

// Optimized solution

class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
}


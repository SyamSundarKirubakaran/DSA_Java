package problems.backtracking;

/**
 * @author SYAM K
 * @problem : Rat in Maze
 */
public class Four {

    static int N;

    public static void main(String[] args) {
        Long start = System.nanoTime();

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        };

        N = maze.length;
        solveMaze(maze);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    static void solveMaze(int[][] maze) {
        int[][] sol = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.print("Solution doesn't exist");
            return;
        }

        printSolution(sol);
    }

    static boolean solveMazeUtil(int[][] maze,
                                 int x,
                                 int y,
                                 int[][] sol) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;

            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            sol[x][y] = 0;
            return false;
        }

        return false;
    }


    static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

}

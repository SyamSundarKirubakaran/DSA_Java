package problems.stack;

import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Celebrity Problem
 */
public class Ten {

    private static int[][] input = new int[][]{
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
    };

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        System.out.print(findCelebrity(input.length - 1) + " ");
    }

    private static int findCelebrity(int size) {
        for (int i = 0; i <= size; i++) {
            stack.push(i);
        }
        int a, b;
        while (stack.size() > 1) {
            a = stack.pop();
            b = stack.pop();
            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int c = stack.pop();
        for (int i = 0; i <= size; i++) {
            if (i != c && (knows(c, i) || !knows(i, c)))
                return -1;
        }
        return c;
    }

    private static boolean knows(int a, int b) {
        return input[a][b] == 1;
    }

}

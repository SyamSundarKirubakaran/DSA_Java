package problems.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Stock Span Problem
 */
public class Seven {

    private static int[] price = new int[]{100, 30, 10, 20, 25, 40, 26, 35, 45};
    private static Stack<Integer> stack = new Stack<>();
    private static int[] span = new int[price.length];

    public static void main(String[] args) {
        findSpan(price, price.length - 1);
        System.out.print(Arrays.toString(span));
    }

    private static void findSpan(int[] price, int size) {
        stack.push(0);
        span[0] = 0;
        for (int i = 1; i <= size; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i : (i - stack.peek() - 1);
            stack.push(i);
        }
    }

}

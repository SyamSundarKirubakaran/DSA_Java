package problems.stack;

import java.util.Stack;

/**
 * @author SYAM K
 * @problem : find duplicate parenthesis present or not
 */
public class I {

    private static String[] input = new String[]{"(", "(", "1", "+", "2", ")", ")"};
    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        boolean isPresent = isUnbalancedPresent(input, input.length - 1);
        System.out.print(isPresent + " ");
    }

    private static boolean isUnbalancedPresent(String[] input, int size) {
        for (int i = 0; i <= size; i++) {
            if (input[i].equals(")")) {
                if (stack.peek().equals("("))
                    return true;
                else {
                    while (!stack.pop().equals("(") && !stack.isEmpty()) ;
                }
            } else {
                stack.push(input[i]);
            }
        }
        return false;
    }

}

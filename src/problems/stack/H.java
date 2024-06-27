package problems.stack;

import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Min no.of bracket reversals req to make the eqn balanced
 */
public class H {

    private static String[] unbalancedIp1 = new String[]{"(", ")", "(", "(", ")", ")", ")", "("};
    private static String[] unbalancedIp2 = new String[]{")", ")", "(", "("};
    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        int result = countMinReversals(unbalancedIp1, unbalancedIp1.length);
        System.out.print(result + " ");
    }

    private static int countMinReversals(String[] ip, int size) {
        if (size % 2 != 0) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (ip[i].equals(")") && !stack.isEmpty()) {
                if (stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    stack.push(ip[i]);
                }
            } else {
                stack.push(ip[i]);
            }
        }
        int unbalancedLength = stack.size();
        int n = 0;
        while (!stack.isEmpty() && stack.peek().equals("(")) {
            stack.pop();
            n++;
        }
        return ((unbalancedLength / 2) + (n % 2));
    }

}

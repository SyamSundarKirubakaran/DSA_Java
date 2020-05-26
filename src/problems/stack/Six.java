package problems.stack;

import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Balancing Parenthesis
 */
public class Six {

    private static String[] unbalancedIp1 = new String[]{"(", ")", "(", "(", ")", ")", ")"};
    private static String[] unbalancedIp2 = new String[]{"(", ")", "(", "(", ")", ")", "("};
    private static String[] balancedIp = new String[]{"(", ")", "(", "(", ")", ")"};

    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        if (unbalancedIp1.length % 2 != 0) {
            System.out.println("unbalanced");
        } else checkBalanced(unbalancedIp1, unbalancedIp1.length - 1);

        if (unbalancedIp2.length % 2 != 0) {
            System.out.println("unbalanced");
        } else checkBalanced(unbalancedIp2, unbalancedIp2.length - 1);

        if (balancedIp.length % 2 != 0) {
            System.out.println("unbalanced");
        } else checkBalanced(balancedIp, balancedIp.length - 1);
    }

    private static void checkBalanced(String[] ip, int size) {
        for (int i = 0; i <= size; i++) {
            if (ip[i].equals("(")) {
                stack.push(ip[i]);
            }
            if (ip[i].equals(")")) {
                if (!stack.isEmpty()) {
                    String peeked = stack.peek();
                    if (peeked.equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(ip[i]);
                    }
                } else {
                    stack.push(ip[i]);
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("unbalanced");
            stack.clear();
        } else {
            System.out.println("balanced");
        }
    }

}

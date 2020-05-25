package problems.stack;

import java.util.Stack;

/**
 * @author SYAM K
 * @problem : getMin @ O(1)
 */
public class Two {

    private static Stack<Integer> stack = new Stack<>();
    private static int currentMin;

    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(5);
        insert(15);
        insert(3);
        insert(6);
        insert(2);
        insert(1);
        printStack();

    }

    private static void printStack() {
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            System.out.print(popped + "(" + currentMin + ") ");
            if (popped < currentMin) {
                currentMin = currentMin - popped;
            }
        }
    }

    private static void insert(int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            currentMin = value;
        } else {
            if (value >= currentMin) {
                stack.push(value);
            } else {
                int result = value - currentMin;
                stack.push(result);
                currentMin = value;
            }
        }
    }

}

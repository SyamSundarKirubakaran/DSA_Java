package problems.stack;

import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Reverse a Stack
 */
public class C {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        reverse();
        printStack();
    }

    private static void printStack() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void reverse() {
        if (!stack.isEmpty()) {
            int popped = stack.peek();
            stack.pop();
            reverse();
            insertAtBottom(popped);
        }
    }

    private static void insertAtBottom(int popped) {
        if (stack.isEmpty()) {
            stack.push(popped);
        } else {
            int newPop = stack.peek();
            stack.pop();
            insertAtBottom(popped);
            stack.push(newPop);
        }
    }

}

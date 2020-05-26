package problems.stack;

import java.util.Stack;

/**
 * @author SYAM K
 * @problem : closest greater element to the right
 */
public class Four {

    private static int[] arr = new int[]{10, 20, 1, 5, 25, 500, 60};
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        findNumber(arr, arr.length - 1);
    }

    private static void findNumber(int[] arr, int size) {
        int element, next;
        stack.push(arr[0]);
        for (int i = 1; i <= size; i++) {
            next = arr[i];
            if (!stack.isEmpty()) {
                element = stack.pop();
                while (next > element) {
                    System.out.print(element + " -> " + next + ", ");
                    if (stack.isEmpty())
                        break;
                    element = stack.pop();
                }
                if (next < element) {
                    stack.push(element);
                }
            }
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> " + null + ", ");
        }
    }

}

package problems.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SYAM K
 * @problem : Stack using Queues
 */
public class One {

    private static Queue<Integer> queue1 = new LinkedList<>();
    private static Queue<Integer> queue2 = new LinkedList<>();

    public static void main(String[] args) {
        insert(7);
        insert(8);
        insert(9);
        insert(10);
        printQueue();
    }

    private static void printQueue() {
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                int popped = queue1.remove();
                System.out.print(popped + " ");
            }
        } else if (!queue2.isEmpty()) {
            while (!queue2.isEmpty()) {
                int popped = queue2.remove();
                System.out.print(popped + " ");
            }
        }
    }

    private static void insert(int value) {
        if (queue1.isEmpty()) {
            queue1.add(value);
            if (!queue2.isEmpty()) {
                while (!queue2.isEmpty()) {
                    int popped = queue2.remove();
                    queue1.add(popped);
                }
            }
        } else if (queue2.isEmpty()) {
            queue2.add(value);
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    int popped = queue1.remove();
                    queue2.add(popped);
                }
            }
        }
    }

}

package problems.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SYAM K
 * @problem : Print all jumping numbers smaller than or equal to given value(k)
 */
public class Seven {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        int x = 40;
        Seven obj = new Seven();
        obj.printJumping(x);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    public void bfs(int x, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while (!q.isEmpty()) {
            num = q.peek();
            q.poll();
            if (num <= x) {
                System.out.print(num + " ");
                int last_digit = num % 10;

                if (last_digit == 0) {
                    q.add((num * 10) + (last_digit + 1));
                } else if (last_digit == 9) {
                    q.add((num * 10) + (last_digit - 1));
                } else {
                    q.add((num * 10) + (last_digit - 1));
                    q.add((num * 10) + (last_digit + 1));
                }
            }
        }
    }

    public void printJumping(int x) {
        System.out.print("0 ");
        for (int i = 1; i <= 9 && i <= x; i++) {
            this.bfs(x, i);
        }
    }

}

package problems.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SYAM K
 * @problem : Print all jumping numbers smaller than or equal to given value(k)
 */
public class Seven {

    public static void main(String[] args) {
        

        int x = 40;
        printJumping(x);
        System.out.println();

        
    }

    public static void bfs(int x, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while (!q.isEmpty()) {
            num = q.peek();
            q.poll();
            if (num <= x) {
                System.out.print(num + " ");
                int last_digit = num % 10;

                if (last_digit == 0) { // If last digit is 0, append next digit only, because can't go negative
                    q.add((num * 10) + (last_digit + 1));
                } else if (last_digit == 9) { // If last digit is 9, append previous digit only, because going beyond 9 gives 2 digit number
                    q.add((num * 10) + (last_digit - 1));
                } else {
                    q.add((num * 10) + (last_digit - 1));
                    q.add((num * 10) + (last_digit + 1));
                }
            }
        }
    }

    public static void printJumping(int x) {
        System.out.print("0 ");
        for (int i = 1; i <= 9 && i <= x; i++) {
            bfs(x, i);
        }
    }

}

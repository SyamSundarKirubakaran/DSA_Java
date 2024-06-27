package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Travelling Sales man (TSP)
 */
public class ZR {

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};
        boolean[] v = new boolean[n];
        v[0] = true;
        int ans = Integer.MAX_VALUE;
        ans = tsp(graph,
                v,
                0,
                n,
                1,
                0,
                ans);
        System.out.println(ans);
    }

    private static int tsp(int[][] graph,
                           boolean[] v,
                           int currentPos,
                           int n,
                           int count,
                           int cost,
                           int ans) {

        if (count == n && graph[currentPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currentPos][0]);
            printTop(v, ans, cost + graph[currentPos][0]);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i] && graph[currentPos][i] > 0) {
                printCount("before true", i, count, v);
                v[i] = true;
                printCount("after true", i, count, v);
                ans = tsp(graph,
                        v,
                        i,
                        n,
                        count + 1,
                        cost + graph[currentPos][i],
                        ans);
                printAll("before false", count, currentPos, i, v);
                v[i] = false;
                printAll("after false", count, currentPos, i, v);
            }
        }
        return ans;
    }

    /*
     Stack Frame: representing traversals
     -------------
     0 -> 1 -> 2 -> 3 => 10 + 35 + 30 + 20 => 95
     0 -> 1 -> 3 -> 2 => 10 + 25 + 30 + 15 => 80
     -------------
     0 -> 2 -> 1 -> 3 => 15 + 35 + 25 + 20 => 95
     0 -> 2 -> 3 -> 1 => 15 + 30 + 25 + 10 => 80
     -------------
     0 -> 3 -> 1 -> 2 => 20 + 25 + 35 + 15 => 95
     0 -> 3 -> 2 -> 1 => 20 + 30 + 35 + 10 => 95
     -------------
     */

    private static void printTop(boolean[] v, int ans, int sum) {
        System.out.println("--------------------");
        System.out.println("Ans: " + ans);
        System.out.println("Sum: " + sum);
        System.out.println("Overall: " + Arrays.toString(v));
        System.out.println("--------------------");
    }

    private static void printCount(String say, int i, int count, boolean[] v) {
        System.out.println("--------------------");
        System.out.println(say);
        System.out.println("Count(before call): " + count);
        System.out.println("@" + i + " " + Arrays.toString(v));
        System.out.println("--------------------");
    }

    private static void printAll(String say, int count, int currentPos, int i, boolean[] v) {
        System.out.println("--------------------");
        System.out.println(say);
        System.out.println("Count(after call): " + count);
        System.out.println("@" + i + " " + Arrays.toString(v));
        System.out.println("--------------------");
    }

}

package problems.dp;

/**
 * @author SYAM K
 * @problem : Travelling Sales man (TSP)
 */
public class FortyFour {

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
            return Math.min(ans, cost + graph[currentPos][0]);
        }

        for (int i = 0; i < n; i++) {
            if (!v[i] && graph[currentPos][i] > 0) {
                v[i] = true;
                ans = tsp(graph,
                        v,
                        i,
                        n,
                        count + 1,
                        cost + graph[currentPos][i],
                        ans);
                v[i] = false;
            }
        }
        return ans;
    }
    /*
     Stack Frame: representing traversals
     -------------
     0 -> 1 -> 2 -> 3
     0 -> 1 -> 3 -> 2
     -------------
     0 -> 2 -> 1 -> 3
     0 -> 2 -> 3 -> 1
     -------------
     0 -> 3 -> 1 -> 2
     0 -> 3 -> 2 -> 1
     -------------
     */

}

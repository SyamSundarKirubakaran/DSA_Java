package problems.dp;

/**
 * @author SYAM K
 * @problem : Multi Stage Graph
 */
public class ZP {

    static int N = 8;
    static int INF = Integer.MAX_VALUE;

    private static final int[][] graph = new int[][]{
            {INF, 1, 2, 5, INF, INF, INF, INF},
            {INF, INF, INF, INF, 4, 11, INF, INF},
            {INF, INF, INF, INF, 9, 5, 16, INF},
            {INF, INF, INF, INF, INF, INF, 2, INF},
            {INF, INF, INF, INF, INF, INF, INF, 18},
            {INF, INF, INF, INF, INF, INF, INF, 13},
            {INF, INF, INF, INF, INF, INF, INF, 2}};

    public static void main(String[] args) {
        shortestDist(graph);
    }

    private static void shortestDist(int[][] graph) {
        int[] dist = new int[N];
        dist[N - 1] = 0;
        for (int i = N - 2; i >= 0; i--) {
            dist[i] = INF;
            for (int j = 1; j < N; j++) {
                if (graph[i][j] == INF) {
                    continue;
                }
                dist[i] = Math.min(dist[i], graph[i][j] + dist[j]);
            }
        }
        System.out.println(dist[0]);
    }

}

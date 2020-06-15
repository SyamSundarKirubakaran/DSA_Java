package problems.graphs;

import java.util.ArrayList;

/**
 * @author SYAM K
 * @problem : Longest Path in DAG
 */
public class Nine {

    int vertices;
    ArrayList<Integer>[] edge;

    Nine(int vertices) {
        this.vertices = vertices;
        edge = new ArrayList[vertices + 1];
        for (int i = 0; i <= vertices; i++) {
            edge[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Long start = System.nanoTime();

        int n = 5;
        Nine graph = new Nine(n);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.findLongestPath(n);
        System.out.println(graph.findLongestPath(n));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    void addEdge(int a, int b) {
        edge[a].add(b);
    }

    void dfs(int node, ArrayList<Integer>[] adj, int[] dp, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < adj[node].size(); i++) {
            if (!visited[adj[node].get(i)])
                dfs(adj[node].get(i), adj, dp, visited);
            dp[node] = Math.max(dp[node], 1 + dp[adj[node].get(i)]);
        }
    }

    int findLongestPath(int n) {
        ArrayList<Integer>[] adj = edge;
        int[] dp = new int[n + 1];

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                dfs(i, adj, dp, visited);
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
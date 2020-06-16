package problems.graphs;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Find Articulation Point / Cut Vertex, Undirected
 */
public class Ten {

    static final int NIL = -1;
    private final int V;
    private final LinkedList<Integer>[] adj;
    int time = 0; // runs upto the number of vertices

    Ten(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println("Articulation points in first graph ");
        Ten g1 = new Ten(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.AP();
        System.out.println();

        System.out.println("Articulation points in Second graph");
        Ten g2 = new Ten(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.AP();
        System.out.println();

        System.out.println("Articulation points in Third graph ");
        Ten g3 = new Ten(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.AP();

        System.out.println();

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // A recursive function that find articulation points using DFS
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    void APUtil(int u,
                boolean[] visited,
                int[] disc,
                int[] low,
                int[] parent,
                boolean[] ap) {
        int children = 0;

        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == NIL && children > 1) // (1) u is root of DFS tree and has two or more chilren.
                    ap[u] = true;
                if (parent[u] != NIL && low[v] >= disc[u]) // (2) If u is not root and low value of one of its child is more than discovery value of u.
                    ap[u] = true;
            } else if (v != parent[u]) // Update low value of u for parent function calls.
                low[u] = Math.min(low[u], disc[v]);
        }
    }

    void AP() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        for (int i = 0; i < V; i++)
            if (!visited[i])
                APUtil(i, visited, disc, low, parent, ap);

        for (int i = 0; i < V; i++)
            if (ap[i])
                System.out.print(i + " ");
    }

}

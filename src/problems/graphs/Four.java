package problems.graphs;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Undirected Graph, cycle or not
 */
public class Four {

    private final int V;
    private final LinkedList<Integer>[] adj;

    Four(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {
        

        Four g1 = new Four(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        Four g2 = new Four(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        Integer i;

        for (Integer value : adj[v]) {
            i = value;
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            } else if (i != parent) // remember this traversal can go both ways, to it's parent and it's children,
                // if not parent and visited return `true` else if visited and parent -> false which is handled outside for loop
                return true;
        }
        return false;
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int u = 0; u < V; u++)
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;

        return false;
    }

}

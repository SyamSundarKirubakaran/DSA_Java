package problems.graphs;


import java.util.ArrayList;
import java.util.Stack;

public class Twelve {

    public static void main(String[] args) {
        Twelve g = new Twelve(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);


//        g.addEdge(2, 1);
//        g.addEdge(5, 1);
//        g.addEdge(1, 3);
//        g.addEdge(1, 4);
//        g.addEdge(4, 3);
//        g.addEdge(3, 6);
//        g.addEdge(4, 6);

        System.out.println("Following is a Topological sort of the given graph");
        g.topologicalSort();
    }

    private final int V;

    private final ArrayList<ArrayList<Integer>> adj;

    Twelve(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void topologicalSortUtil(int v, boolean[] visited,
                             Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent
        // to this vertex
        for (Integer integer : adj.get(v)) {
            i = integer;
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(v);
    }

    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    void topologicalSort() {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

}

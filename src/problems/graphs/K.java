package problems.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Longest Path in DAG, with weights
 */
public class K {

    static final int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        

        K t = new K();
        Graph g = t.newGraph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances from source " + s);
        g.shortestPath(s);

        System.out.println();

        
    }

    Graph newGraph(int number) {
        return new Graph(number);
    }

    static class AdjListNode {
        private final int v;
        private final int weight;

        AdjListNode(int _v, int _w) {
            v = _v;
            weight = _w;
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }
    }

    public static class Graph {
        private final int V;
        private final LinkedList<AdjListNode>[] adj;

        Graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int u, int v, int weight) {
            AdjListNode node = new AdjListNode(v, weight);
            adj[u].add(node);
        }

        void topologicalSortUtil(int v, Boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;

            for (AdjListNode node : adj[v]) {
                if (!visited[node.getV()])
                    topologicalSortUtil(node.getV(), visited, stack);
            }

            stack.push(v);
        }

        void shortestPath(int s) {
            Stack<Integer> stack = new Stack<>();
            int[] dist = new int[V];

            Boolean[] visited = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            for (int i = 0; i < V; i++)
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);


            for (int i = 0; i < V; i++)
                dist[i] = MIN;
            dist[s] = 0;

            while (!stack.empty()) {
                int u = stack.pop();
                Iterator<AdjListNode> it;
                if (dist[u] != MIN) {
                    it = adj[u].iterator();
                    while (it.hasNext()) {
                        AdjListNode i = it.next();
                        if (dist[u] + i.getWeight() > dist[i.getV()])
                            dist[i.getV()] = dist[u] + i.getWeight();
                    }
                }
            }

            for (int i = 0; i < V; i++) {
                if (dist[i] == MIN)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i] + " ");
            }
        }
    }

}

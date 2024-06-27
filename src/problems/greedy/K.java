package problems.greedy;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Kruskal's Algorithm
 */
public class K {

    int V, E;
    Edge[] edge;

    Eleven(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    public static void main(String[] args) {
        

         /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;
        int E = 5;
        Eleven g = new Eleven(V, E);

        // add edge 0-1
        g.edge[0].src = 0;
        g.edge[0].dest = 1;
        g.edge[0].weight = 10;

        // add edge 0-2
        g.edge[1].src = 0;
        g.edge[1].dest = 2;
        g.edge[1].weight = 6;

        // add edge 0-3
        g.edge[2].src = 0;
        g.edge[2].dest = 3;
        g.edge[2].weight = 5;

        // add edge 1-3
        g.edge[3].src = 1;
        g.edge[3].dest = 3;
        g.edge[3].weight = 15;

        // add edge 2-3
        g.edge[4].src = 2;
        g.edge[4].dest = 3;
        g.edge[4].weight = 4;

        g.KruskalMST();

        
    }

    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree (Union by Rank)
        if (subsets[xRoot].rank < subsets[yRoot].rank)
            subsets[xRoot].parent = yRoot;
        else if (subsets[xRoot].rank > subsets[yRoot].rank)
            subsets[yRoot].parent = xRoot;
        else {
            // If ranks are same, then make one as root and increment, its rank by one
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    void KruskalMST() {
        Edge[] result = new Edge[V];
        int i;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset[] subsets = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        int e = 0;
        while (e < V - 1) {
            Edge nextEdge = edge[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e] = nextEdge;
                e += 1;
                Union(subsets, x, y);
            }
        }

        System.out.println(Arrays.toString(edge));

        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
    }


    static class subset {
        int parent, rank;
    }

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    ", weight=" + weight +
                    '}';
        }
    }

}

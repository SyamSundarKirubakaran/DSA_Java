package problems.graphs;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Bipartite or not
 */
public class Five {

    static final int V = 4;

    public static void main(String[] args) {
        

        int[][] G = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        if (isBipartite(G))
            System.out.println("Yes");
        else
            System.out.println("No");

        
    }

    static boolean colorGraph(int[][] G,
                              int[] color,
                              int pos,
                              int c) {
        if (color[pos] != -1 && color[pos] != c) // already colored & not equal to the color that it's suppose to have
            return false;

        // color this pos as c and
        // all its neighbours as `1 - c`
        color[pos] = c;
        boolean ans = true;
        for (int i = 0; i < V; i++) {
            if (G[pos][i] == 1) { // has an edge
                if (color[i] == -1) // not colored
                    ans = colorGraph(G, color, i, 1 - c);

                if (color[i] != -1 && color[i] != 1 - c) // already colored & not equal to the color that it's suppose to have
                    return false;
            }
            if (!ans)
                return false;
        }
        return true;
    }

    static boolean isBipartite(int[][] G) {
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = -1;

        int pos = 0;
        boolean result = colorGraph(G, color, pos, 1); // possible colors -> 1 & 0
        System.out.println("Colors: " + Arrays.toString(color));
        return result;
    }

}

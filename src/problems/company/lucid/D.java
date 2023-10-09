package problems.company.lucid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/collect-the-coins-in-minimum-number-of-steps/

class D {
    public int collectTheCoins(int[] coins, int[][] edges) {

        int n = edges.length;
        ArrayList<HashSet<Integer>> g = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int totalEdges = 2 * n;
        int deletedEdges = 0;

        // Part I: Create Graph
        for (int i = 0; i <= n; i++) {
            g.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            g.get(a).add(b);
            g.get(b).add(a);
        }

        // Part II: Find Element whose in-degree is 1 and not a coin
        for (int i = 0; i <= n; i++) {
            if (g.get(i).size() == 1 && coins[i] == 0) {
                q.add(i);
            }
        }

        // Remove subtree which is not required
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (g.get(curr).size() == 0) {
                continue;
            }
            int p = g.get(curr).iterator().next(); // set will have only 1 element
            g.get(curr).remove(p);
            g.get(p).remove(curr);
            if (g.get(p).size() == 1 && coins[p] == 0) {
                q.add(p);
            }
            deletedEdges += 2;
        }

        // Part III: Include all leaf nodes (with coins)
        for (int i = 0; i <= n; i++) {
            if (g.get(i).size() == 1) {
                q.add(i);
            }
        }

        // remove coin node, and it's parent basis on their in-degree
        int size = 2; // for removing child then parent edges
        while (size > 0) {
            size--;
            int qSize = q.size();
            while (qSize > 0) {
                qSize--;

                int curr = q.remove();
                if (g.get(curr).size() == 0) {
                    continue;
                }

                int p = g.get(curr).iterator().next();
                g.get(curr).remove(p);
                g.get(p).remove(curr);

                if (g.get(p).size() == 1) {
                    q.add(p);
                }
                deletedEdges += 2;
            }
        }


        return totalEdges - deletedEdges;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 0, 0, 0, 0, 1};
        int[][] edges = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };

        System.out.println(new D().collectTheCoins(coins, edges));
    }

}

package generic_workout.company.tesla.set1;

import java.util.*;

// https://leetcode.com/problems/maximal-network-rank/

public class H {


        public int maximalNetworkRank(int n, int[][] roads) {
            int maxRank = 0;
            Map<Integer, Set<Integer>> adj = new HashMap<>();
            // Construct adjency list 'adj', where adj[node] stores all nodes connected to 'node'.
            for (int[] road : roads) {
                adj.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
                adj.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
            }

            // Iterate on each possible pair of nodes.
            for (int node1 = 0; node1 < n; ++node1) {
                for (int node2 = node1 + 1; node2 < n; ++node2) {
                    int currentRank = adj.getOrDefault(node1, Collections.emptySet()).size() +
                            adj.getOrDefault(node2, Collections.emptySet()).size();

                    // Find the current pair's respective network rank and store if it's maximum till now.
                    if (adj.getOrDefault(node1, Collections.emptySet()).contains(node2)) {
                        --currentRank;
                    }
                    maxRank = Math.max(maxRank, currentRank);
                }
            }
            // Return the maximum network rank.
            return maxRank;
        }

    public static void main(String[] args) {
        System.out.println(new H().maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));
    }

}

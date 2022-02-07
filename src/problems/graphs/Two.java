package problems.graphs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : BFS
 */
public class Two {

    public static void main(String[] args) {
        Node node = constructGraph();
        bfs(node, 4);
    }

    private static void bfs(Node node, int vertices) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean[] visited = new boolean[vertices];
        visited[node.value] = true;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.value);
            for (Node temp : node.adj) {
                if (!visited[temp.value]) {
                    visited[temp.value] = true;
                    queue.add(temp);
                }
            }
        }
    }

    private static Node constructGraph() {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        zero.adj.addAll(Arrays.asList(one, two));
        one.adj.add(two);
        two.adj.addAll(Arrays.asList(zero, three));
        three.adj.add(three);

        return two;
    }

    public static class Node {
        int value;
        LinkedList<Node> adj;

        Node(int value) {
            this.value = value;
            adj = new LinkedList<>();
        }
    }

}

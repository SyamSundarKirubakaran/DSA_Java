package problems.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : DFS
 */
public class One {

    public static void main(String[] args) {
        Node node = constructGraph();
        dfs(node, 4);
    }

    private static void dfs(Node node, int vertices) {
        // this array should belong to the stack record, that's why a separate function
        boolean[] visited = new boolean[vertices];
        dfsUtil(node, visited);
    }

    private static void dfsUtil(Node node, boolean[] visited) {
        visited[node.value] = true;
        System.out.println(node.value);

        Iterator<Node> nodeIterator = node.adj.listIterator();
        while (nodeIterator.hasNext()) {
            Node n = nodeIterator.next();
            if (!visited[n.value]) {
                dfsUtil(n, visited);
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
        return zero;
    }

    static class Node {
        int value;
        LinkedList<Node> adj;

        Node(int value) {
            this.value = value;
            adj = new LinkedList<>();
        }
    }

}

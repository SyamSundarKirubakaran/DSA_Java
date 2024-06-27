package problems.trees;

import problems.trees.util.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author SYAM K
 * @problem : Diagonal Traversal BT
 */
public class ZC {

    private static HashMap<Integer, List<Node>> map = new HashMap<>();

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        performDiagonalTraversal(head, 0);
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            for (Node values : entry.getValue()) {
                System.out.print(values.value + " ");
            }
        }
    }

    private static void performDiagonalTraversal(Node node, int d) {
        if (node == null) return;
        List<Node> n = map.get(d);
        if (n == null) {
            List<Node> list = new LinkedList<>();
            list.add(node);
            map.put(d, list);
        } else {
            n.add(node);
            map.put(d, n);
        }
        performDiagonalTraversal(node.left, d + 1);
        performDiagonalTraversal(node.right, d);
    }
}

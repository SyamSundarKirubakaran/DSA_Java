package problems.trees;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author SYAM K
 * @problem : Top View
 */
public class Fifteen {

    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private static LinkedHashMap<Integer, Node> hash = new LinkedHashMap<>();

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        findTopView(head);
    }

    private static void findTopView(Node node) {
        findMinMax(node, 0);
        for (int lineNo = min; lineNo <= max; lineNo++) {
            inflateTopView(node, lineNo, 0);
        }
        for (Map.Entry<Integer, Node> entry : hash.entrySet()) {
            System.out.print(entry.getValue().value + " ");
        }
    }

    private static void inflateTopView(Node node, int lineNo, int hd) {
        if (node == null)
            return;
        if (hd == lineNo)
            hash.putIfAbsent(lineNo, node);
        inflateTopView(node.left, lineNo, hd - 1);
        inflateTopView(node.right, lineNo, hd + 1);
    }

    private static void findMinMax(Node node, int index) {
        if (node == null)
            return;
        if (index < min) min = index;
        if (index > max) max = index;
        findMinMax(node.left, index - 1);
        findMinMax(node.right, index + 1);
    }

}

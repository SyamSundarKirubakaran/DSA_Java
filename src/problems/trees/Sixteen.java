package problems.trees;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author SYAM K
 * @problem : Bottom View
 */
public class Sixteen {

    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private static HashMap<Integer, Node> hash = new LinkedHashMap<>();

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        printBottomView(head);
    }

    private static void printBottomView(Node node) {
        findMinMax(node, 0);
        for (int lineNo = min; lineNo <= max; lineNo++) {
            inflateHash(node, lineNo, 0);
        }
        for (Map.Entry<Integer, Node> entry : hash.entrySet()) {
            System.out.print(entry.getValue().value + " ");
        }
    }

    private static void inflateHash(Node node, int lineNo, int index) {
        if (node == null) return;
        if (index == lineNo)
            hash.put(lineNo, node);
        inflateHash(node.left, lineNo, index - 1);
        inflateHash(node.right, lineNo, index + 1);
    }

    private static void findMinMax(Node node, int index) {
        if (node == null) return;
        if (index < min) min = index;
        if (index > max) max = index;
        findMinMax(node.left, index - 1);
        findMinMax(node.right, index + 1);
    }

}

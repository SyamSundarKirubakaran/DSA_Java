package problems.trees;

import problems.trees.util.Node;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Multiplication of Sums of data of leaves at same level
 */
public class ZE {

    private static LinkedList<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        Node node = new Node().constructBalancedBST();
        new Node().preOrderTraversal(node);
        System.out.print(sumAndMultiplyLevelData(node) + " ");
    }

    private static int sumAndMultiplyLevelData(Node node) {
        int sum, result = 1;
        boolean leafFound;
        if (node == null) return 0;
        queue.addLast(node);
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) break;
            sum = 0;
            leafFound = false;
            while (nodeCount > 0) {
                Node n = queue.removeFirst();
                if (n.left == null && n.right == null) {
                    leafFound = true;
                    sum += node.value;
                }
                if (n.left != null)
                    queue.addLast(n.left);
                if (n.right != null)
                    queue.addLast(n.right);
                nodeCount -= 1;
            }
            if (leafFound) {
                result = result * sum;
            }
        }
        return result;
    }

}

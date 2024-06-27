package problems.trees;

import problems.trees.util.Node;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Multiplication of Sums of data at same level
 */
public class ZF {

    private static LinkedList<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        Node node = new Node().constructBalancedBST();
        System.out.print(compute(node) + " ");
    }

    private static int compute(Node node) {
        int sum, result = 1;
        if (node == null) return 0;
        Node popped;
        queue.addLast(node);
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) break;
            sum = 0;
            while (nodeCount > 0) {
                popped = queue.removeFirst();
                sum += popped.value;
                if (popped.left != null)
                    queue.addLast(popped.left);
                if (popped.right != null)
                    queue.addLast(popped.right);
                nodeCount -= 1;
            }
            result *= sum;
        }
        return result;
    }

}

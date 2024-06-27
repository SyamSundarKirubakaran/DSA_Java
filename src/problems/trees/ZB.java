package problems.trees;

import problems.trees.util.Node;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Extreme nodes of each level in alternating order
 */
public class ZB {

    private static LinkedList<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        printExtremeNodes(head);
    }

    private static void printExtremeNodes(Node node) {
        if (node == null) return;
        queue.addLast(node);
        boolean flag = false;
        Node temp;
        while (!queue.isEmpty()) {

            int nodeCount = queue.size();
            int n = nodeCount;

            while (n-- > 0) {
                temp = queue.peek();
                if (temp.left != null)
                    queue.addLast(temp.left);
                if (temp.right != null)
                    queue.addLast(temp.right);
                queue.remove();

                if (flag && n == nodeCount - 1)
                    System.out.print(temp.value + " ");
                if (!flag && n == 0)
                    System.out.print(temp.value + " ");
            }

            flag = !flag;
        }
    }

}

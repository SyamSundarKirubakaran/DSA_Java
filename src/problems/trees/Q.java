package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Left View
 */
public class Q {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        leftView(head, 0);
        Node head1 = new Node().constructUnBalancedTreeLeft();
        leftView(head1, 0);
    }

    private static void leftView(Node node, int level) {
        if (node == null) return;
        if (level > max) {
            System.out.print(node.value + " ");
            max = level;
        }
        leftView(node.left, level + 1);
        leftView(node.right, level + 1);
    }
}

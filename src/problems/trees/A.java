package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Size of a Binary Tree
 */
public class A {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        System.out.println(findTreeSize(head));
        Node head1 = new Node().constructUnBalancedTreeLeft();
        System.out.println(findTreeSize(head1));
        Node head2 = new Node().constructUnBalancedTreeRight();
        System.out.println(findTreeSize(head2));
    }

    private static int findTreeSize(Node node) {
        if (node == null)
            return 0;
        else
            return findTreeSize(node.left) + findTreeSize(node.right) + 1;
    }

}

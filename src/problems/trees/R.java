package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Remove all nodes whose length = K in BT.
 */
public class R {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        new Node().inOrderTraversal(removePaths(head, 2));
    }

    private static Node removePaths(Node node, int k) {
        if (node == null) return null;
        if (k == 0) return null;
        node.left = removePaths(node.left, k - 1);
        node.right = removePaths(node.right, k - 1);
        return node;
    }
}

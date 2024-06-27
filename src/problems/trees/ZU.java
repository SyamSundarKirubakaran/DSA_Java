package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Remove all paths whose length < K in BT.
 */
public class ZU {

    public static void main(String[] args) {
        Node head = new Node().constructUnBalancedTreeLeft();
        new Node().inOrderTraversal(removeShortPathNodes(head, 3));
    }

    private static Node removeShortPathNodesUtil(Node node, int level, int k) {
        if (node == null)
            return null;

        node.left = removeShortPathNodesUtil(node.left, level + 1, k);
        node.right = removeShortPathNodesUtil(node.right, level + 1, k);

        if (node.left == null && node.right == null && level < k)
            return null;

        return node;
    }


    private static Node removeShortPathNodes(Node node, int k) {
        return removeShortPathNodesUtil(node, 1, k);
    }

}

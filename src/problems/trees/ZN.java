package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Convert a given tree into sum tree
 */
public class ZN {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        convertToSumTree(head);
        new Node().preOrderTraversal(head);
    }

    private static int convertToSumTree(Node head) {
        if (head == null) return 0;
        int prev = head.value;
        int left = convertToSumTree(head.left);
        int right = convertToSumTree(head.right);
        head.value = left + right;
        return head.value + prev;
    }

}

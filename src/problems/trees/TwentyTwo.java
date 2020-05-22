package problems.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SYAM K
 * @problem : BST into Balanced BST
 */
public class TwentyTwo {

    private static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Node head = new Node().constructUnBalancedBST();
        performInOrderInflate(head);
        Node resultHead = constructBalancedBST(list, 0, list.size() - 1);
        new Node().inOrderTraversal(resultHead);
    }

    private static Node constructBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        Node node = new Node(list.get(middle));
        node.left = constructBalancedBST(list, start, middle - 1);
        node.right = constructBalancedBST(list, middle + 1, end);
        return node;
    }

    private static void performInOrderInflate(Node node) {
        if (node != null) {
            performInOrderInflate(node.left);
            list.add(node.value);
            performInOrderInflate(node.right);
        }
    }


}

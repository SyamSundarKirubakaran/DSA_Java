package problems.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SYAM K
 * @problem : BT construction from the given POST and IN Order
 */
public class Y {

    private static final List<Integer> inOrder = new LinkedList<>();
    private static final List<Integer> postOrder = new LinkedList<>();
    static int postOrderIndex;

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        findInOrder(head);
        System.out.println();
        findPostOrder(head);
        System.out.println();
        postOrderIndex = inOrder.size() - 1;
        Node result = construct(inOrder, postOrder, 0, inOrder.size() - 1);
        new Node().preOrderTraversal(result);
    }

    /**
     * 0
     * /       \
     * 1         2
     * /   \     /  \
     * 3     4   5    6
     * / \   / \ / \  / \
     */

    private static Node construct(List<Integer> inOrder,
                                  List<Integer> postOrder,
                                  int inStart,
                                  int inEnd) {
        if (inStart > inEnd || postOrderIndex < 0) return null;
        Node node = new Node(postOrder.get(postOrderIndex));
        postOrderIndex -= 1;
        if (inStart == inEnd) return node;
        int inIndex = searchInInOrder(inOrder, inStart, inEnd, node.value);
        node.right = construct(inOrder, postOrder, inIndex + 1, inEnd);
        node.left = construct(inOrder, postOrder, inStart, inIndex - 1);
        return node;
    }

    private static int searchInInOrder(List<Integer> inOrder, int inStart, int inEnd, int value) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder.get(i) == value)
                return i;
        }
        return -1;
    }

    private static void findPostOrder(Node head) {
        if (head != null) {
            findPostOrder(head.left);
            findPostOrder(head.right);
            postOrder.add(head.value);
            System.out.print(head.value + " ");
        }
    }

    private static void findInOrder(Node head) {
        if (head != null) {
            findInOrder(head.left);
            inOrder.add(head.value);
            System.out.print(head.value + " ");
            findInOrder(head.right);
        }
    }


}

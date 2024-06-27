package problems.trees;

import problems.trees.util.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SYAM K
 * @problem : BT construction from the given PRE and IN Order
 */
public class ZV {

    private static final List<Integer> inOrder = new LinkedList<>();
    private static final List<Integer> preOrder = new LinkedList<>();
    static int preOrderIndex = 0;

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        findInOrder(head);
        findPreOrder(head);
        Node result = construct(inOrder, preOrder, 0, inOrder.size() - 1);
        new Node().postOrderTraversal(result);
    }

    private static Node construct(List<Integer> inOrder, List<Integer> preOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        Node node = new Node(preOrder.get(preOrderIndex));
        preOrderIndex += 1;
        if (inStart == inEnd) return node;
        int inIndex = searchInInOrder(inOrder, inStart, inEnd, node.value);
        node.left = construct(inOrder, preOrder, inStart, inIndex - 1);
        node.right = construct(inOrder, preOrder, inIndex + 1, inEnd);
        return node;
    }

    private static int searchInInOrder(List<Integer> inOrder, int inStart, int inEnd, int value) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder.get(i) == value)
                return i;
        }
        return -1;
    }

    private static void findPreOrder(Node head) {
        if (head != null) {
            preOrder.add(head.value);
            findPreOrder(head.left);
            findPreOrder(head.right);
        }
    }

    private static void findInOrder(Node head) {
        if (head != null) {
            findInOrder(head.left);
            inOrder.add(head.value);
            findInOrder(head.right);
        }
    }

}

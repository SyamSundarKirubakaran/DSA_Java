package problems.trees;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Find the next right node of a given node in the same level
 */
public class ThirtyEight {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        findNextRight(head, 1);
    }

    private static void findNextRight(Node head, int k) {
        if (head == null) return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(head);
        Node node;
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);
            if (node.value == k)
                break;
        }
        if (queue.peekFirst() != null)
            System.out.print(queue.removeFirst().value + " ");
        else
            System.out.print("Nothing present to right of " + k);
    }

}

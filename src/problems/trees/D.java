package problems.trees;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Level Order Traversal
 */
public class D {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        performLevelOrderTraversal(head);
    }

    private static void performLevelOrderTraversal(Node head) {
        if (head != null) {
            LinkedList<Node> queue = new LinkedList<>();
            queue.addLast(head);
            Node temp;
            while (!queue.isEmpty()) {
                temp = queue.removeFirst();
                System.out.print(temp.value + " ");
                if (temp.left != null)
                    queue.addLast(temp.left);
                if (temp.right != null)
                    queue.addLast(temp.right);
            }
        }
    }
}

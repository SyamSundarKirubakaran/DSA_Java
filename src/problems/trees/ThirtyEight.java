package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SYAM K
 * @problem : Find the next right node of a given node in the same level
 */
public class ThirtyEight {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        Node result = nextRight(head, 1);
        if (result != null)
            System.out.println(result.value);
        else
            System.out.println("No node to its right");
    }

    private static Node nextRight(Node head, int k) {
        if (head == null)
            return null;
        Queue<Node> qn = new LinkedList<Node>();
        Queue<Integer> ql = new LinkedList<Integer>();

        int level = 0;
        qn.add(head);
        ql.add(level);

        while (qn.size() != 0) {
            Node node = qn.peek();
            level = ql.peek();
            qn.remove();
            ql.remove();

            if (node.value == k) {
                if (ql.size() == 0 || ql.peek() != level)
                    return null;
                return qn.peek();
            }

            if (node.left != null) {
                qn.add(node.left);
                ql.add(level + 1);
            }
            if (node.right != null) {
                qn.add(node.right);
                ql.add(level + 1);
            }
        }

        return null;
    }
}

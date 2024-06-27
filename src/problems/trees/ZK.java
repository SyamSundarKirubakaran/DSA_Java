package problems.trees;

import problems.trees.util.Node;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Complete Binary Tree from a LL
 */
public class ZK {

    private static LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

    public static void main(String[] args) {
        Node result = constructTree(linkedList);
        new Node().preOrderTraversal(result);
    }

    private static Node constructTree(LinkedList<Integer> linkedList) {
        int popped = linkedList.removeFirst();
        Node node = new Node(popped);
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        Node left, right;
        while (linkedList.size() > 0) {
            Node poppedNode = queue.removeFirst();
            left = new Node(linkedList.removeFirst());
            right = new Node(linkedList.removeFirst());
            poppedNode.left = left;
            poppedNode.right = right;
            queue.addLast(left);
            queue.addLast(right);
        }
        return node;
    }

    private static boolean isPowerOfTwo(int x) {
        return (x != 0) && ((x & (x - 1)) == 0);
    }

}

package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Print nodes at k distance form root
 */
public class J {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        printKFromRoot(head, 2, 0);
    }

    private static void printKFromRoot(Node node, int k, int distance) {
        if (node != null) {
            if (distance == k) {
                System.out.print(node.value + " ");
                return;
            }
            printKFromRoot(node.left, k, distance + 1);
            printKFromRoot(node.right, k, distance + 1);
        }
    }


}

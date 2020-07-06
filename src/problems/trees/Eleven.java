package problems.trees;

/**
 * @author SYAM K
 * @problem : Print nodes at K distance from any node in BT
 */
public class Eleven {
    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        printKDistanceFromAnyNode(head, new Node(1), 1);
    }

    // Similar to all nodes at a distance K from the root
    private static void printKDistanceDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(node.value + " ");
            return;
        }
        printKDistanceDown(node.left, k - 1);
        printKDistanceDown(node.right, k - 1);
    }

    private static int printKDistanceFromAnyNode(Node node, Node target, int k) {
        if (node == null)
            return -1;
        if (node.value == target.value) {
            printKDistanceDown(node, k);
            return 0;
        }
        int dl = printKDistanceFromAnyNode(node.left, target, k);
        if (dl != -1) {
            if (dl + 1 == k)
                System.out.print(node.value + " ");
            else
                printKDistanceDown(node.right, k - dl - 2);
            return dl + 1;
        }
        int dr = printKDistanceFromAnyNode(node.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k)
                System.out.print(node.value + " ");
            else
                printKDistanceDown(node.left, k - dr - 2);
            return dr + 1;
        }
        return -1;
    }
}

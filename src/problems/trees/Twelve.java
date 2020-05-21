package problems.trees;

/**
 * @author SYAM K
 * @problem : Vertical Tree Order Traversal
 */
public class Twelve {

    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        printVertical(head);
    }

    private static void printVertical(Node node) {
        findMinMax(node, 0);
        for (int i = min; i <= max; i++) {
            performPrint(node, i, 0);
        }
    }

    private static void performPrint(Node node, int index, int hd) {
        if (node == null) return;
        if (index == hd)
            System.out.print(node.value + " ");
        performPrint(node.left, index, hd - 1);
        performPrint(node.right, index, hd + 1);
    }

    private static void findMinMax(Node node, int index) {
        if (node == null)
            return;
        if (index < min) min = index;
        if (index > max) max = index;
        findMinMax(node.left, index - 1);
        findMinMax(node.right, index + 1);
    }
}

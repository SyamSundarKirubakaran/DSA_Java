package problems.trees;

/**
 * @author SYAM K
 * @problem : Vertical Sum of the Binary Tree
 */
public class Thirteen {

    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        performVerticalSum(head);
    }

    private static void performVerticalSum(Node node) {
        int sum;
        finMinMax(node, 0);
        for (int i = min; i <= max; i++) {
            sum = computeSum(node, i, 0);
            System.out.print(sum + " ");
        }
    }

    private static int computeSum(Node node, int lineNo, int hd) {
        if (node == null) return 0;
        if (lineNo == hd)
            return node.value + computeSum(node.left, lineNo, hd - 1) + computeSum(node.right, lineNo, hd + 1);
        return computeSum(node.left, lineNo, hd - 1) + computeSum(node.right, lineNo, hd + 1);
    }

    private static void finMinMax(Node node, int index) {
        if (node == null) return;
        if (index < min) min = index;
        if (index > max) max = index;
        finMinMax(node.left, index - 1);
        finMinMax(node.right, index + 1);
    }

}

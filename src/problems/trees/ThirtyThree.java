package problems.trees;

/**
 * @author SYAM K
 * @problem : Max of all differences of a node and it's ancestors BT
 */
public class ThirtyThree {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node node = new Node().constructBalancedBST();
        findMaxDiff(node);
        System.out.print(max + " ");
    }

    private static int findMaxDiff(Node node) {
        int left, right;
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return node.value;
        left = findMaxDiff(node.left);
        right = findMaxDiff(node.right);
        int min = Math.min(left, right);
        max = Math.max(max, node.value - min);
        return Math.min(min, node.value);
    }

}

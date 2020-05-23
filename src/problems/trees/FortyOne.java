package problems.trees;

/**
 * @author SYAM K
 * @problem : Check if Foldable or not
 */
public class FortyOne {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        System.out.print(checkIfFoldable(head) + " ");
        Node head1 = new Node().constructUnBalancedTreeLeft();
        System.out.print(checkIfFoldable(head1) + " ");
    }

    private static boolean checkIfFoldable(Node head) {
        if (head == null) return true;
        return isFoldable(head.left, head.right);
    }

    private static boolean isFoldable(Node left, Node right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return isFoldable(left.left, right.right) && isFoldable(left.right, right.left);
    }

}

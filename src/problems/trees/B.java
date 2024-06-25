package problems.trees;

/**
 * @author SYAM K
 * @problem : Identical or not
 */
public class B {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        Node head1 = new Node().constructBalancedTree();
        System.out.println(findIdentical(head, head1));
        Node head2 = new Node().constructUnBalancedTreeRight();
        Node head3 = new Node().constructBalancedTree();
        System.out.println(findIdentical(head2, head3));
    }

    private static boolean findIdentical(Node head1, Node head2) {
        if (head1 == null && head2 == null)
            return true;
        if (head1 != null && head2 != null && head1.value == head2.value) {
            boolean leftCheck = findIdentical(head1.left, head2.left);
            if (!leftCheck) return false;
            return findIdentical(head1.right, head2.right);
        }
        return false;
    }


}

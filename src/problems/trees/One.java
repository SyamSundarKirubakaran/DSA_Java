package problems.trees;

/**
 * @author SYAM K
 * @problem : Size of a Binary Tree
 */
public class One {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        performPreOrderTraversal(head);
        System.out.println();
        Node head1 = new Node().constructUnBalancedTreeLeft();
        performPreOrderTraversal(head1);
        System.out.println();
        Node head2 = new Node().constructUnBalancedTreeRight();
        performPreOrderTraversal(head2);
    }

    private static void performPreOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            performPreOrderTraversal(node.left);
            performPreOrderTraversal(node.right);
        }
    }

}

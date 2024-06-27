package problems.trees;

/**
 * @author SYAM K
 * @problem : Mirror Tree
 */
public class C {

    public static void main(String[] args) {
        Node head1 = new Node().constructBalancedTree();
        constructMirrorTree(head1);
        new Node().preOrderTraversal(head1);
    }

    private static void constructMirrorTree(Node node) {
        if (node == null) return;
        constructMirrorTree(node.left);
        constructMirrorTree(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}

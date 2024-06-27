package problems.trees;

/**
 * @author SYAM K
 * @problem : Lowest Common Ancestor (LCA) - BST
 */
public class E {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedBST();
        System.out.println(findLCA(head, 1, 7).value);
        System.out.println(findLCA(head, 5, 7).value);
    }

    private static Node findLCA(Node node, int p, int q) {
        if (node == null)
            return null;
        if (p < node.value && q < node.value) {
            return findLCA(node.left, p, q);
        }
        if (p > node.value && q > node.value) {
            return findLCA(node.right, p, q);
        }
        return node;
    }
}

package problems.trees;

/**
 * @author SYAM K
 * @problem : Lowest Common Ancestor (LCA) - Binary Tree
 */
public class Six {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        System.out.println(findLCA(head, 3, 6).value);
        System.out.println(findLCA(head, 3, 4).value);
    }

    private static Node findLCA(Node node, int p, int q) {
        if (node == null) return null;
        if (node.value == p || node.value == q) {
            return node;
        }
        Node left = findLCA(node.left, p, q);
        Node right = findLCA(node.right, p, q);
        if (left != null && right != null)
            return node;
        return (left != null) ? left : right;
    }

}

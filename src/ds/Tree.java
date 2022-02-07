package ds;

/**
 * @author SYAM K
 */
public class Tree {
    public static void main(String[] args) {
        Node root = new Node(0);
        inflateDummyData(root);
        System.out.println("In order:");
        performInOrderTraversal(root);
        System.out.println();
        System.out.println("Pre order:");
        performPreOrderTraversal(root);
        System.out.println();
        System.out.println("Post order:");
        performPostOrderTraversal(root);
    }

    private static void performPostOrderTraversal(Node root) {
        if (root != null) {
            performPostOrderTraversal(root.left);
            performPostOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    private static void performPreOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            performPreOrderTraversal(root.left);
            performPreOrderTraversal(root.right);
        }
    }

    private static void performInOrderTraversal(Node root) {
        if (root != null) {
            performInOrderTraversal(root.left);
            System.out.print(root.value + " ");
            performInOrderTraversal(root.right);
        }
    }

    private static void inflateDummyData(Node root) {
        Node child1 = new Node(1);
        Node child2 = new Node(2);
        Node child3 = new Node(3);
        Node child4 = new Node(4);
        Node child5 = new Node(5);
        Node child6 = new Node(6);
        root.left = child1;
        root.right = child2;
        child1.left = child3;
        child1.right = child4;
        child2.left = child5;
        child2.right = child6;
    }

    public static class Node {
        int value;
        Node left, right;

        Node(int nodeValue) {
            value = nodeValue;
            left = null;
            right = null;
        }
    }
}

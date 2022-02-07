package ds;

/**
 * @author SYAM K
 * @problem : AVL Tree
 */
public class AVLTree {

    static int height(Node node) {
        return node == null ? 0 : node.height;
    }

    static Node rotateRight(Node root) {
        Node t1 = root.left;
        Node t2 = t1.right;
        t1.right = root;
        root.left = t2;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        t1.height = Math.max(height(t1.left), height(t1.right)) + 1;

        return t1;
    }

    static Node rotateLeft(Node root) {
        Node t1 = root.right;
        Node t2 = t1.left;

        t1.left = root;
        root.right = t2;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        t1.height = Math.max(height(t1.left), height(t1.right)) + 1;

        return t1;
    }

    static int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);
        // LL
        if (balance > 1 && data < root.left.data) {
            return rotateRight(root);
        }
        // RR
        if (balance < -1 && data > root.right.data) {
            return rotateLeft(root);
        }
        // LR
        if (balance > 1 && data > root.left.data) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        // RL
        if (balance < -1 && data < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }

    static void countSmallerArray(int[] arr, int size) {
        Node root = null;
        for (int i = size - 1; i >= 0; i--) {
            root = insert(root, arr[i]);
        }
        performPreOrderTraversal(root);
        System.out.println();
        performInOrderTraversal(root);
    }

    private static void performInOrderTraversal(Node root) {
        if (root != null) {
            performInOrderTraversal(root.left);
            System.out.print(root.data + " ");
            performInOrderTraversal(root.right);
        }
    }

    private static void performPreOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            performPreOrderTraversal(root.left);
            performPreOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 3, 4, 5, 7, 1, 3, 2};
        countSmallerArray(input, input.length);
    }

    public static class Node {
        int data, height;
        Node left, right;

        Node(int value) {
            data = value;
            height = 1;
            left = null;
            right = null;
        }
    }


}

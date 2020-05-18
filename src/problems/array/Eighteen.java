package problems.array;


/**
 * @author SYAM K
 * @problem : count the no.of smaller elements to the right of each element in the array.
 */

public class Eighteen {

    static int height(Node node) {
        return node == null ? 0 : node.height;
    }

    static int size(Node node) {
        return node == null ? 0 : node.size;
    }

    static Node rotateRight(Node root) {
        Node t1 = root.left;
        Node t2 = t1.right;
        t1.right = root;
        root.left = t2;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        t1.height = Math.max(height(t1.left), height(t1.right)) + 1;

        root.size = size(root.left) + size(root.right) + 1;
        t1.size = size(t1.left) + size(t1.right) + 1;

        return t1;
    }

    static Node rotateLeft(Node root) {
        Node t1 = root.right;
        Node t2 = t1.left;

        t1.left = root;
        root.right = t2;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        t1.height = Math.max(height(t1.left), height(t1.right)) + 1;

        root.size = size(root.left) + size(root.right) + 1;
        t1.size = size(t1.left) + size(t1.right) + 1;

        return t1;
    }

    static int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    static Node insert(Node root, int data, int[] smaller, int index) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data, smaller, index);
        } else {
            root.right = insert(root.right, data, smaller, index);
            smaller[index] += size(root.left) + 1;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        root.size = size(root.left) + size(root.right) + 1;

        int balance = getBalance(root);
        if (balance > 1 && data < root.left.data) {
            return rotateRight(root);
        }
        if (balance < -1 && data > root.right.data) {
            return rotateLeft(root);
        }
        if (balance > 1 && data > root.left.data) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (balance < -1 && data < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }

    static void countSmallerArray(int[] arr, int size) {
        Node root = null;
        int[] smaller = new int[size];
        for (int i = 0; i < size; i++) {
            smaller[i] = 0;
        }
        for (int i = size - 1; i >= 0; i--) {
            root = insert(root, arr[i], smaller, i);
        }
        printArray(smaller);
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 3, 4, 5, 7, 1, 3, 2};
        countSmallerArray(input, input.length);
    }

    static class Node {
        int data, height, size;
        Node left, right;

        Node(int value) {
            data = value;
            height = 1;
            size = 1;
            left = null;
            right = null;
        }
    }

}

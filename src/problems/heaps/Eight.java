package problems.heaps;

import java.util.Vector;

/**
 * @author SYAM K
 * @problem : Convert BST to MAX Heap
 */
public class Eight {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        //   4
        //   /\
        //   2 6
        //  /\ /\
        // 1 3 5 7

        Node root = getNode(4);
        root.left = getNode(2);
        root.right = getNode(6);
        root.left.left = getNode(1);
        root.left.right = getNode(3);
        root.right.left = getNode(5);
        root.right.right = getNode(7);

        convertToMaxHeapUtil(root);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static void reverseInorderTraversal(Node root, Vector<Integer> arr) {
        // Inorder of a BST -> always ascending order
        // reverseInorder of a BST -> always descending order -> automatically a MAX heap
        if (root == null)
            return;
        reverseInorderTraversal(root.right, arr);
        arr.add(root.data);
        reverseInorderTraversal(root.left, arr);
    }

    static void convertToMaxHeapUtil(Node root) {
        Vector<Integer> arr = new Vector<>();
        reverseInorderTraversal(root, arr);
        System.out.println("Max Heap: " + arr);
    }

    static Node getNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    public static class Node {
        int data;
        Node left, right;
    }

}

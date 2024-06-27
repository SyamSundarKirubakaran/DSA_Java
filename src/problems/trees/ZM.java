package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Boundary Traversal
 */
public class ZM {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        printLeftBoundary(head);
        printLeaves(head);
        printRightBoundary(head);
    }

    private static void printRightBoundary(Node head) {
        if (head != null) {
            if (head.right != null) {
                printRightBoundary(head.right);
                System.out.print(head.value + " ");
            } else if (head.left != null) {
                printRightBoundary(head.left);
                System.out.print(head.value + " ");
            }
        }
    }

    private static void printLeaves(Node head) {
        if (head != null) {
            if (head.left == null && head.right == null)
                System.out.print(head.value + " ");
            printLeaves(head.left);
            printLeaves(head.right);
        }
    }

    private static void printLeftBoundary(Node head) {
        if (head != null) {
            if (head.left != null) {
                System.out.print(head.value + " ");
                printLeftBoundary(head.left);
            } else if (head.right != null) {
                System.out.print(head.value + " ");
                printLeftBoundary(head.right);
            }
        }
    }

}

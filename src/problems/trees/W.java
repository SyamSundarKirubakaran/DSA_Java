package problems.trees;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Print all paths possible from root to all leaves
 */
public class W {

    private static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Node head = new Node().constructUnBalancedTreeLeft();
        findPaths(head, 0);
    }

    private static void findPaths(Node head, int index) {
        if (head != null) {
            list.add(index, head.value);
            index += 1;
            if (isLeaf(head))
                printList(list, index);
            else {
                findPaths(head.left, index);
                findPaths(head.right, index);
            }
        }
    }

    private static void printList(LinkedList<Integer> list, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    private static boolean isLeaf(Node head) {
        return (head.left == null && head.right == null);
    }
}

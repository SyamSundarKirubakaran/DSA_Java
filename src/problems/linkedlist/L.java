package problems.linkedlist;

import problems.linkedlist.util.Node;

/**
 * @author SYAM K
 * @problem : Merge sort on LL
 */
public class L {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().constructBasicUnSortedEvenLengthLL();
        Node.SLLNode result = mergeSort(head);
        new Node().printSLL(result);
    }

    private static Node.SLLNode mergeSort(Node.SLLNode head) {
        if (head == null || head.next == null) return head;
        Node.SLLNode middle = findMiddle(head);
        Node.SLLNode secondStart = middle.next;
        middle.next = null;
        Node.SLLNode left = mergeSort(head);
        Node.SLLNode right = mergeSort(secondStart);
        return merge(left, right);
    }

    private static Node.SLLNode merge(Node.SLLNode left, Node.SLLNode right) {
        Node.SLLNode result;
        if (left == null) return right;
        if (right == null) return left;

        if (left.value <= right.value) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private static Node.SLLNode findMiddle(Node.SLLNode head) {
        if (head == null || head.next == null) return head;
        Node.SLLNode slowPtr = head;
        Node.SLLNode fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }


}

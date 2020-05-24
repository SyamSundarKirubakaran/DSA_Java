package problems.LinkedList;

/**
 * @author SYAM K
 * @problem : Kth Node from the end of LL
 */
public class Three {
    public static void main(String[] args) {
        Node.SLLNode head = new Node().constructBasicEvenLengthLL();
        Node.SLLNode result = findKBeforeEnd(head, 1);
        System.out.print(result.value + " ");
    }

    private static Node.SLLNode findKBeforeEnd(Node.SLLNode head, int k) {
        if (head == null || head.next == null) return head;
        Node.SLLNode slowPtr = head;
        Node.SLLNode fastPtr = head;
        for (int i = 0; i < k; i++) {
            fastPtr = fastPtr.next;
        }
        while (fastPtr.next != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }
}

package problems.LinkedList;

/**
 * @author SYAM K
 * @problem : Reverse a LL
 */
public class One {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().constructBasicEvenLengthLL();
        new Node().print(head);
        System.out.println();
        new Node().print(reverse(head));
    }

    private static Node.SLLNode reverse(Node.SLLNode head) {
        if (head == null || head.next == null) return head;
        Node.SLLNode prev = null;
        Node.SLLNode current = head;
        Node.SLLNode upcoming;
        while (current != null) {
            upcoming = current.next;
            current.next = prev;
            prev = current;
            current = upcoming;
        }
        return prev;
    }

}

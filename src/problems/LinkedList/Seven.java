package problems.LinkedList;

/**
 * @author SYAM K
 * @problem : Alternating Split
 */
public class Seven {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().constructBasicEvenLengthLL();
        constructAlternatingLL(head);
    }

    private static void constructAlternatingLL(Node.SLLNode head) {
        if (head == null || head.next == null)
            return;
        Node.SLLNode head1 = head;
        Node.SLLNode head2 = head.next;
        Node.SLLNode temp = head2;
        while (head2.next != null) {
            head1.next = head1.next.next;
            head2.next = head2.next.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        head1.next = null;
        new Node().printSLL(head);
        System.out.println();
        new Node().printSLL(temp);
    }

}

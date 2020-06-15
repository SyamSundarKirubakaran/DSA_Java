package problems.linkedlist;

/**
 * @author SYAM K
 * @problem : Middle of a LL
 */
public class Two {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().constructBasicOddLengthLL();
        Node.SLLNode middleNode = findMiddle(head);
        System.out.print(middleNode.value + " ");
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

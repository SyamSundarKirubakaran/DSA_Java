package problems.linkedlist;

/**
 * @author SYAM K
 * @problem : Palindrome of a LL
 */
public class Nine {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().constructEvenLengthPalindromeLL();
        findPalindrome(head);
        System.out.println();
        Node.SLLNode head1 = new Node().constructOddLengthPalindromeLL();
        findPalindrome(head1);
        System.out.println();
        Node.SLLNode head2 = new Node().constructBasicEvenLengthLL();
        findPalindrome(head2);
    }

    private static void findPalindrome(Node.SLLNode head) {
        if (head == null || head.next == null) return;
        Node.SLLNode headCopy = head;
        Node.SLLNode middleNode = findMiddle(head);
        Node.SLLNode secondListStart = middleNode.next; // start is form the next node of the middle node
        middleNode.next = null; // first List's last node's next = null
        Node.SLLNode beginning = reverse(secondListStart);
        // usually 2 list have equal nodes if length of init list is even or list 2 has less nodes if odd
        // Therefore for safer side chose list 2
        while (beginning.next != null) {
            if (headCopy.value == beginning.value) {
                headCopy = headCopy.next;
                beginning = beginning.next;
            } else break;
        }
        System.out.print(beginning.next == null);
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

    private static Node.SLLNode findMiddle(Node.SLLNode head) {
        Node.SLLNode slowPtr = head;
        Node.SLLNode fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

}

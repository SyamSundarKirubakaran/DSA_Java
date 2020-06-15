package problems.linkedlist;

/**
 * @author SYAM K
 * @problem : 2 LL merge at a point and become a single List, find that point
 */
public class Six {

    public static void main(String[] args) {
        Node.SLLNode head1 = new Node.SLLNode(0);
        Node.SLLNode head2 = new Node().constructMergingListAtANodeNotEqual(head1);
        Node.SLLNode result = detectNode(head1, head2);
        System.out.print(result.value + " ");
    }

    private static Node.SLLNode detectNode(Node.SLLNode head1, Node.SLLNode head2) {
        int length1 = findLength(head1);
        int length2 = findLength(head2);
        int diff;
        Node.SLLNode max, other;
        if (length1 > length2) {
            diff = length1 - length2;
            max = head1;
            other = head2;
        } else {
            diff = length2 - length1;
            max = head2;
            other = head1;
        }
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                max = max.next;
            }
        }
        while (max != other) {
            max = max.next;
            other = other.next;
        }
        return max;
    }

    private static int findLength(Node.SLLNode head1) {
        int count = 0;
        while (head1 != null) {
            count += 1;
            head1 = head1.next;
        }
        return count;
    }

}

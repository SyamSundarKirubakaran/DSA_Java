package problems.linkedlist;

/**
 * @author SYAM K
 * @problem : Merge 2 Sorted LL into one Sorted LL
 */
public class Ten {

    public static void main(String[] args) {
        Node.SLLNode head1 = new Node().constructHigherOrderEvenLengthLLOne();
        Node.SLLNode head2 = new Node().constructHigherOrderEvenLengthLLTwo();
        Node.SLLNode result = merge(head1, head2);
        new Node().printSLL(result);
    }

    private static Node.SLLNode merge(Node.SLLNode head1, Node.SLLNode head2) {
        Node.SLLNode mergeList, temp;
        if (head1 == null || head2 == null) {
            return (head1 == null) ? head2 : head1;
        }
        if (head1.value <= head2.value) {
            mergeList = head1;
            head1 = head1.next;
        } else {
            mergeList = head2;
            head2 = head2.next;
        }
        temp = mergeList;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        temp.next = (head1 != null) ? head1 : head2;
        return mergeList;
    }

}

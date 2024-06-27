package problems.linkedlist;

import problems.linkedlist.util.Node;

/**
 * @author SYAM K
 * @problem : Sort a LL with 0s, 1s and 2s
 */
public class O {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().zerosOnesTwosLL();
        Node.SLLNode result = separate(head);
        new Node().printSLL(result);
    }

    private static Node.SLLNode separate(Node.SLLNode head) {
        if (head == null || head.next == null) return head;
        Node.SLLNode zeroDummy = new Node.SLLNode(0);
        Node.SLLNode oneDummy = new Node.SLLNode(0);
        Node.SLLNode twoDummy = new Node.SLLNode(0);

        Node.SLLNode zero = zeroDummy, one = oneDummy, two = twoDummy;
        Node.SLLNode current = head;

        while (current != null) {
            if (current.value == 0) {
                zero.next = current;
                zero = zero.next;
            }
            if (current.value == 1) {
                one.next = current;
                one = one.next;
            }
            if (current.value == 2) {
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }

        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;

        head = zeroDummy.next;

        return head;
    }

}

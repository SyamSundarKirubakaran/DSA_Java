package problems.linkedlist;

import problems.linkedlist.util.Node;

/**
 * @author SYAM K
 * @problem : Find start of the loop with the LL with Loop
 */
public class E {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().constructBasicEvenLengthLLWithLoop();
        System.out.print(findLoopBeg(head).value + " ");
    }

    private static Node.SLLNode findLoopBeg(Node.SLLNode head) {
        if (head == null || head.next == null) return head;
        Node.SLLNode slowPtr = head;
        Node.SLLNode fastPtr = head;
        boolean flag = false;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                flag = true;
                break;
            }
        }
        if (flag) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            return slowPtr;
        } else {
            return null;
        }
    }

}

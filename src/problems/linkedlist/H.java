package problems.linkedlist;

import problems.linkedlist.util.Node;

/**
 * @author SYAM K
 * @problem : Clone a LL that contains Random Pointer (Custom LL)
 */
public class H {

    public static void main(String[] args) {
        Node.CustomNode head = new Node().constructCustomLLWithRandom();
        new Node().printCustomLL(head);
        System.out.println();
        Node.CustomNode result = clone(head);
        new Node().printCustomLL(result);
    }

    private static Node.CustomNode clone(Node.CustomNode head) {
        if (head == null || head.next == null) return head;
        Node.CustomNode headCopy1 = head;
        Node.CustomNode headCopy2 = head;
        while (head != null) {
            Node.CustomNode nextPtr = head.next;
            Node.CustomNode temp = new Node.CustomNode(head.value);
            head.next = temp;
            temp.next = nextPtr;
            head = nextPtr;
        }
        while (headCopy1 != null) {
            headCopy1.next.random = headCopy1.random.next;
            headCopy1 = headCopy1.next.next;
        }
        Node.CustomNode decoupleHead = headCopy2.next;
        Node.CustomNode secondListStart = decoupleHead;
        while (decoupleHead != null && decoupleHead.next != null) {
            decoupleHead.next = decoupleHead.next.next;
            decoupleHead = decoupleHead.next;
        }
        return secondListStart;
    }

}


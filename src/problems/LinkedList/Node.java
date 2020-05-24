package problems.LinkedList;

/**
 * @author SYAM K
 * @problem : Singly Linked List Node
 */
public class Node {

    SLLNode constructBasicEvenLengthLL() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(3);
        SLLNode four = new SLLNode(4);
        SLLNode five = new SLLNode(5);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return zero;
    }

    SLLNode constructBasicEvenLengthLLWithLoop() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(3);
        SLLNode four = new SLLNode(4);
        SLLNode five = new SLLNode(5);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = two;
        return zero;
    }

    SLLNode constructBasicOddLengthLL() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(3);
        SLLNode four = new SLLNode(4);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        return zero;
    }

    void print(SLLNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    static class SLLNode {
        int value;
        SLLNode next;

        SLLNode(int value) {
            this.value = value;
            next = null;
        }
    }

}

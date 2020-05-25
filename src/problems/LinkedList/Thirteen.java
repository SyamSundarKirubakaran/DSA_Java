package problems.LinkedList;

/**
 * @author SYAM K
 * @problem : LL with arb-pointer pointing to greatest in the right side of the current node
 */
public class Thirteen {

    public static void main(String[] args) {
        Node head = constructList();
        Node result = inflateArb(head);
        print(result);
    }

    private static void print(Node head) {
        while (head.next != null) {
            System.out.print(head.value + "(" + head.arb.value + ") ");
            head = head.next;
        }
        System.out.print(head.value + "(null)");
    }

    private static Node inflateArb(Node head) {
        Node reversedHead = reverse(head);
        Node maxSoFar = reversedHead;
        Node startNode = reversedHead.next;
        Node startNodeCopy = startNode;
        while (startNode != null) {
            startNode.arb = maxSoFar;
            if (startNode.value > maxSoFar.value) {
                maxSoFar = startNode;
            }
            startNode = startNode.next;
        }
        reversedHead.next = startNodeCopy;
        return reverse(reversedHead);
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node current = head;
        Node upcoming;
        while (current != null) {
            upcoming = current.next;
            current.next = prev;
            prev = current;
            current = upcoming;
        }
        return prev;
    }

    private static Node constructList() {
        Node zero = new Node(0);
        Node one = new Node(3);
        Node two = new Node(11);
        Node three = new Node(10);
        Node four = new Node(4);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        return zero;
    }

    static class Node {
        int value;
        Node arb, next;

        Node(int value) {
            this.value = value;
            arb = null;
            next = null;
        }
    }

}

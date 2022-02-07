package ds;

/**
 * @author SYAM K
 */
public class Stack {
    public static void main(String[] args) {
        Node head;
        head = push(new Node(0), 1);
        head = push(head, 2);
        printLinkedList(head);
        head = pop(head);
        printLinkedList(head);
        head = pop(head);
        printLinkedList(head);
        head = pop(head);
        printLinkedList(head);
        head = push(head, 3);
        head = push(head, 4);
        head = push(head, 5);
        printLinkedList(head);
    }

    // Head, Deleted Node

    public static Node pop(Node head) {
        if (head == null) {
            System.out.println("Nothing to pop.!");
            return null;
        }
        System.out.println("Popped: " + head.value);
        head = head.next;
        return head;
    }

    public static Node push(Node head, int value) {
        Node newNode = new Node(value);
        if (head != null) newNode.next = head;
        return newNode;
    }

    private static void printLinkedList(Node temp) {
        String postAttachment;
        while (temp != null) {
            if (temp.next != null)
                postAttachment = " -> ";
            else postAttachment = "";
            System.out.print(temp.value + postAttachment);
            temp = temp.next;
        }
        System.out.println();
    }

    public static class Node {
        int value;
        Node next;

        public Node() {
            value = -1;
            next = null;
        }

        private Node(int nodeValue) {
            value = nodeValue;
            next = null;
        }
    }
}

package ds;

/**
 * @author SYAM K
 */
public class Queue {
    public static void main(String[] args) {
        Node head, tail;
        Node firstNode = new Node(0);
        head = tail = firstNode;
        tail = enqueue(tail, 1);
        tail = enqueue(tail, 2);
        tail = enqueue(tail, 3);
        tail = enqueue(tail, 4);
        printLinkedList(head);
        head = dequeue(head);
        printLinkedList(head);
        head = dequeue(head);
        printLinkedList(head);
        head = dequeue(head);
        printLinkedList(head);
        head = dequeue(head);
        printLinkedList(head);
        head = dequeue(head);
        printLinkedList(head);
        head = dequeue(head);
        printLinkedList(head);
    }

    public static Node dequeue(Node head) {
        if (head == null) {
            System.out.println("Nothing to dequeue");
            return null;
        }
        System.out.println("Dequeue: " + head.value);
        head = head.next;
        return head;
    }

    public static Node enqueue(Node tail, int nodeValue) {
        Node newNode = new Node(nodeValue);
        if (tail != null) tail.next = newNode;
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

        Node() {
            value = -1;
            next = null;
        }

        Node(int nodeValue) {
            value = nodeValue;
            next = null;
        }
    }
}

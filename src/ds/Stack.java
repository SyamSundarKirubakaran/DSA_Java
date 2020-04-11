package ds;

import javafx.util.Pair;

/**
 * @author SYAM K
 */
public class Stack {
    public static void main(String[] args) {
        Node head;
        Pair<Node, Node> popped;
        head = push(new Node(0), 1);
        head = push(head, 2);
        printLinkedList(head);
        popped = pop(head);
        System.out.println("Popped: " + popped.getValue().value);
        printLinkedList(popped.getKey());
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

    // Head, Deleted Node
    public static Pair<Node, Node> pop(Node head) {
        Node temp = head;
        if (head != null) head = head.next;
        return new Pair<>(head, temp);
    }

    public static Node push(Node head, int value) {
        Node newNode = new Node(value);
        if (head != null) newNode.next = head;
        return newNode;
    }

    static class Node {
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

package ds;

/**
 * @author SYAM K
 */
public class DoublyLinkedList {
    public static void main(String[] args) {
        Node head = new Node();
        inflateDummyValues(head);
        printLinkedListValues(head);

        head = insertAtBeginning(head, 12);
        printLinkedListValues(head);
        insertNodeAtEnd(head, 10);
        printLinkedListValues(head);
        head = insertAtIndex(head, 2, 19);
        printLinkedListValues(head);

        head = moveNodeAtIndexToBeginning(head, 2);
        printLinkedListValues(head);

        head = reverseLinkedList(head);
        printLinkedListValues(head);

        head = deleteAtBeginning(head);
        printLinkedListValues(head);
        deleteAtEnd(head);
        printLinkedListValues(head);
        head = deleteAtIndex(head, 1);
        printLinkedListValues(head);
    }

    private static Node deleteAtIndex(Node head, int index) {
        Node temp = head;
        if (index == 0) {
            head = head.next;
            head.previous = null;
        } else {
            if (head == null || head.next == null) return null;
            while (--index > 0 && temp.next != null) temp = temp.next;
            if (temp.next == null) {
                temp.previous.next = null;
                return head;
            }
            if (temp.next.next != null) {
                temp.next = temp.next.next;
                temp.next.previous = temp;
            } else
                temp.next = null;
        }
        return head;
    }

    private static void deleteAtEnd(Node head) {
        while (head.next != null && head.next.next != null) head = head.next;
        head.next = null;
    }

    private static Node deleteAtBeginning(Node head) {
        if (head != null) {
            head = head.next;
            head.previous = null;
        }
        return head;
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;
        Node current = head;
        Node temp;
        while (current.next != null) {
            temp = current.next;
            current.next = current.previous;
            current.previous = current.next;
            current = temp;
        }
        current.next = current.previous;
        current.previous = null;
        return current;
    }

    private static Node moveNodeAtIndexToBeginning(Node head, int index) {
        Node temp = head;
        Node targetNode = head;
        if (head == null) return null;
        while (--index > 0 && temp != null) temp = temp.next;
        if (temp == null) return head;
        if (temp.next != null && temp.next.next != null) {
            targetNode = temp.next;
            temp.next = targetNode.next;
            targetNode.next = head;
            temp.next.previous = temp;
            targetNode.previous = null;
            targetNode.next.previous = targetNode;
        }
        return targetNode;
    }

    private static Node insertAtIndex(Node head, int index, int value) {
        Node newNode = new Node(value);
        Node temp = head;
        Node newHead;
        if (index == 0) {
            newHead = insertAtBeginning(head, value);
            return newHead;
        }
        while (--index > 0 && temp != null) temp = temp.next;
        if (temp.next == null) {
            insertNodeAtEnd(head, value);
            return head;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.previous = temp;
        newNode.next.previous = newNode;
        return head;
    }

    private static void insertNodeAtEnd(Node head, int value) {
        Node newNode = new Node(value);
        while (head.next != null) head = head.next;
        newNode.previous = head;
        head.next = newNode;
    }

    private static Node insertAtBeginning(Node head, int value) {
        Node newHead = new Node(value);
        if (head == null) {
            return newHead;
        } else {
            head.previous = newHead;
            newHead.next = head;
            head = newHead;
            return head;
        }
    }

    private static void printLinkedListValues(Node head) {
        String appender;
        while (head != null) {
            if (head.next != null) appender = " -> ";
            else appender = "";
            System.out.print(head.value + appender);
            head = head.next;
        }
        System.out.println();
    }

    private static Node inflateDummyValues(Node head) {
        head.value = 0;
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.next = node1;
        node1.next = node2;
        node1.previous = head;
        node2.next = node3;
        node2.previous = node1;
        node3.next = node4;
        node3.previous = node2;
        node4.next = node5;
        node4.previous = node3;
        node5.next = null;
        node5.previous = node4;
        return head;
    }

    public static class Node {
        public int value;
        public Node previous;
        public Node next;

        public Node() {
            value = -1;
            previous = null;
            next = null;
        }

        public Node(int nodeValue) {
            value = nodeValue;
            previous = null;
            next = null;
        }
    }

}

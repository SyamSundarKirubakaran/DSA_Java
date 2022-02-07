package ds;

/**
 * @author SYAM K
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node();
        inflateSampleLinkedListData(head);
        head = insertAtBeginning(head, 0);
        printLinkedList(head);
        insertNodeAtEnd(head, 5);
        printLinkedList(head);
        insertAtIndex(head, 2, 10);
        printLinkedList(head);

        head = moveNodeAtIndexToBeginning(head, 2);
        printLinkedList(head);

        head = reverseLinkedList(head);
        printLinkedList(head);

        head = deleteAtBeginning(head);
        printLinkedList(head);
        deleteAtEnd(head);
        printLinkedList(head);
        head = deleteAtIndex(head, 3);
        printLinkedList(head);
    }

    private static Node moveNodeAtIndexToBeginning(Node head, int index) {
        if (index == 0) return head;
        Node temp = head;
        while (--index > 0) temp = temp.next;
        Node temp1 = temp.next;
        if (temp.next != null && temp.next.next != null)
            temp.next = temp.next.next;
        else
            temp.next = null;
        temp1.next = head;
        head = temp1;
        return head;
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null, current = head, upcoming = head.next, temp;
        while (upcoming != null) {
            current.next = prev;
            temp = upcoming;
            upcoming = upcoming.next;
            temp.next = current;
            prev = current;
            current = temp;
        }
        return current;
    }

    private static Node deleteAtBeginning(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    private static void deleteAtEnd(Node head) {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        while (head.next != null && head.next.next != null) {
            head = head.next;
        }
        head.next = null;
    }

    private static Node deleteAtIndex(Node head, int index) {
        Node temp = head;
        Node resultHead;
        if (index == 0)
            resultHead = deleteAtBeginning(head);
        else {
            while (--index > 0) head = head.next;
            if (head.next != null && head.next.next != null) {
                head.next = head.next.next;
            } else if (head.next != null) {
                deleteAtEnd(temp);
            }
            resultHead = temp;
        }
        return resultHead;
    }

    private static Node insertAtBeginning(Node head, int nodeValue) {
        Node newNode = new Node(nodeValue);
        newNode.next = head;
        head = newNode;
        return head;
    }

    private static void insertAtIndex(Node head, int index, int nodeValue) {
        Node newNode = new Node(nodeValue);
        Node temp = head;
        while (--index > 0) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    private static void insertNodeAtEnd(Node head, int nodeValue) {
        Node newNode = new Node(nodeValue);
        Node lastNode = traverseToEnd(head);
        lastNode.next = newNode;
    }

    private static Node traverseToEnd(Node temp) {
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
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

    private static void inflateSampleLinkedListData(Node head) {
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        head.value = 1;
        node2.value = 2;
        node3.value = 3;
        node4.value = 4;
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node() {
            value = -1;
            next = null;
        }

        public Node(int nodeValue) {
            value = nodeValue;
            next = null;
        }
    }

}

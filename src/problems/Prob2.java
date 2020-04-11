package problems;

/**
 * @author SYAM K
 * @problem : Use a stacks to design a queue
 */
public class Prob2 {
    public static void main(String[] args) {
        Node head = new Node(0);
        head = push(head, 1);
        head = push(head, 2);
        head = push(head, 3);
        head = push(head, 4);
        System.out.println("Stack Entries: ");
        print(head);
        head = reverse(head);
        System.out.println("Queue Entries: ");
        print(head);
        head = pop(head);
        print(head);
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null, current = head, upcoming = current.next, temp;
        while (current != null) {
            current.next = prev;
            prev = current;
            current = upcoming;
            if (upcoming != null)
                upcoming = upcoming.next;
        }
        return prev;
    }

    private static Node pop(Node head) {
        if (head != null) {
            System.out.println("Popped: " + head.value);
            head = head.next;
        } else {
            System.out.println("Nothing to pop");
        }
        return head;
    }

    private static Node push(Node head, int nodeValue) {
        Node newNode = new Node(nodeValue);
        newNode.next = head;
        return newNode;
    }

    private static void print(Node head) {
        String appender;
        while (head != null) {
            if (head.next == null) appender = "";
            else appender = " -> ";
            System.out.print(head.value + appender);
            head = head.next;
        }
        System.out.println();
    }

    static class Node {
        int value;
        Node next;

        Node(int nodeValue) {
            value = nodeValue;
            next = null;
        }
    }
}

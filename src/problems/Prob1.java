package problems;

import javafx.util.Pair;

/**
 * @author SYAM K
 * @problem : Use 2 stacks to design a queue
 */
public class Prob1 {
    public static void main(String[] args) {
        Node head = new Node(0);
        head = push(head, 1);
        head = push(head, 2);
        head = push(head, 3);
        System.out.println("1st Stack entries: ");
        printLinkedList(head);
        head = dumpToNewStack(head);
        System.out.println("2nd Stack entries: (which is basically a queue)");
        printLinkedList(head);
    }

    private static Node dumpToNewStack(Node head) {
        if (head == null) return null;
        Pair<Node, Node> initPopPair = pop(head);
        Node newStackHead = initPopPair.getValue();
        head = initPopPair.getKey();
        if (head == null) return null;
        Pair<Node, Node> popPair;
        while (head != null) {
            popPair = pop(head);
            newStackHead = pushNode(newStackHead, popPair.getValue());
            head = popPair.getKey();
        }
        return newStackHead;
    }

    public static void printLinkedList(Node head) {
        String appenderString;
        while (head != null) {
            if (head.next == null) appenderString = "";
            else appenderString = " -> ";
            System.out.print(head.value + appenderString);
            head = head.next;
        }
        System.out.println();
    }

    // returns Pair<new head, popped node>
    public static Pair<Node, Node> pop(Node head) {
        Node poppedNode = null;
        if (head != null) {
            poppedNode = head;
            head = head.next;
            poppedNode.next = null;
        } else {
            System.out.println("Nothing to pop.!");
        }
        return new Pair<>(head, poppedNode);
    }

    public static Node push(Node head, int nodeValue) {
        Node newNode = new Node(nodeValue);
        if (head != null) newNode.next = head;
        return newNode;
    }

    public static Node pushNode(Node head, Node newNode) {
        if (head != null) newNode.next = head;
        return newNode;
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

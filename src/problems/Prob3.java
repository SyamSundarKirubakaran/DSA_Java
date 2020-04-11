package problems;

import java.util.Arrays;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Convert a given infix expression to postfix notation - using stack
 */
public class Prob3 {

    List<String> operators = Arrays.asList("*", "/", "-", "/");

    public static void main(String[] args) {
        String infixExpression = "a+b-c";
        Node head = null;
        for (int i = 0; i < infixExpression.length(); i++) {
            int asciiValue = infixExpression.charAt(i);
            if (!(asciiValue >= 97 && asciiValue <= 122)) {
                head = push(head, infixExpression.charAt(i));
            } else {
                System.out.print(infixExpression.charAt(i) + " ");
            }
        }
        if (head != null)
            while (head != null) {
                head = pop(head);
            }
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

    private static Node pop(Node head) {
        if (head == null) return null;
        System.out.print(head.value + " ");
        head = head.next;
        return head;
    }

    private static Node push(Node head, char nodeValue) {
        Node newNode = new Node(nodeValue);
        newNode.next = head;
        return newNode;
    }

    static class Node {
        char value;
        Node next;

        Node(char nodeValue) {
            value = nodeValue;
            next = null;
        }
    }

}

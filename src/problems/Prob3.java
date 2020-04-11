package problems;

/**
 * @author SYAM K
 * @problem : Convert a given infix expression to postfix notation - using stack
 */
public class Prob3 {

    public static void main(String[] args) {
        String infixExpression = "a*b+c";
        Node head = null;
        for (int i = 0; i < infixExpression.length(); i++) {
            char charValue = infixExpression.charAt(i);
            if (!(charValue >= 97 && charValue <= 122)) {
                if (head == null)
                    head = push(null, infixExpression.charAt(i));
                else if (findPrecedence(charValue) >= findPrecedence(head.value))
                    head = push(head, infixExpression.charAt(i));
                else {
                    while (head != null) {
                        head = pop(head);
                    }
                    head = push(null, infixExpression.charAt(i));
                }
            } else {
                System.out.print(infixExpression.charAt(i) + " ");
            }
        }
        if (head != null)
            while (head != null) {
                head = pop(head);
            }
    }

    private static int findPrecedence(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return 0;
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

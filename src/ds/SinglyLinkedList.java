package ds;

/**
 * @author SYAM K
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node();
        inflateSampleLinkedListData(head);
        head = insertAtBeginning(head, 0);
        insertNodeAtEnd(head, 5);
        insertAtIndex(head, 2, 10);
        Node temp = head;
        printLinkedList(temp);
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
        int indexCopy = index;
        while (indexCopy > 1) {
            temp = temp.next;
            indexCopy -= 1;
        }
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
}

package algo.sort;

import ds.Node;

import java.util.*;

/**
 * @author SYAM K
 */
public class BucketSort {

    public static void main(String[] args) {
        // Bucket Sort useful for floating point sorting or decimals with same no of digits.
        List<Integer> integerList = Arrays.asList(22, 33, 11, 55, 99, 77, 66, 88, 12, 96);
        System.out.println(performBucketSort(integerList));
    }

    private static List<Integer> performBucketSort(List<Integer> integerList) {
        HashMap<Integer, Node> map = new HashMap<>();
        List<Integer> sortedList = new ArrayList<>();
        Node head;
        int insertionCount;
        for (int i = 0; i < 10; i++) {
            map.put(i, new Node());
        }
        for (int i = 0; i < integerList.size(); i++) {
            int digit = Character.getNumericValue(integerList.get(i).toString().charAt(0));
            insertionCount = 0;
            head = map.get(digit);
            if (head.value == -1) {
                head.value = integerList.get(i);
            } else {
                Node temp = head;
                while (temp != null) {
                    if (temp.value <= integerList.get(i)) {
                        insertionCount += 1;
                        if (temp.next == null) {
                            insertNodeAtEnd(head, integerList.get(i));
                            break;
                        } else
                            temp = temp.next;
                    } else {
                        if (insertionCount == 0) {
                            Node newHead = insertAtBeginning(head, integerList.get(i));
                            map.put(digit, newHead);
                        } else
                            insertAtIndex(head, insertionCount, integerList.get(i));
                        break;
                    }
                }
            }
        }
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            head = entry.getValue();
            while (head != null) {
                if (head.value != -1)
                    sortedList.add(head.value);
                head = head.next;
            }
        }
        return sortedList;
    }

    private static int getNodeCount(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count += 1;
        }
        return count;
    }

    private static Node insertAtIndex(Node head, int index, int nodeValue) {
        Node newNode = new Node(nodeValue);
        Node temp = head;
        int indexCopy = index;
        while (indexCopy > 1) {
            temp = temp.next;
            indexCopy -= 1;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
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

    private static Node insertAtBeginning(Node head, int nodeValue) {
        Node newNode = new Node(nodeValue);
        newNode.next = head;
        head = newNode;
        return head;
    }

}

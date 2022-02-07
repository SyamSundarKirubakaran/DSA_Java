package algo.sort;

import java.util.Map;
import java.util.TreeMap;

class BucketSort {
    // Can be used only when all the entries in the input have same no of digits
    static int[] arr = new int[]{22, 33, 11, 55, 99, 77, 66, 88, 12, 13, 14, 59, 67, 20};

    public static void main(String[] args) {
        performBucketSort();
    }

    static void performBucketSort() {
        TreeMap<Integer, Node> bucket = new TreeMap<>();
        Node head, fromBucket;
        for (int value : arr) {
            int chosenEntry = findBucket(value);
            if (bucket.get(chosenEntry) == null) {
                bucket.put(chosenEntry, new Node(value));
            } else {
                fromBucket = bucket.get(chosenEntry);
                Node newNode = new Node(value);
                if (fromBucket.value > value) {
                    newNode.next = fromBucket;
                    bucket.put(chosenEntry, newNode);
                } else {
                    head = properPlace(fromBucket, value);
                    if (head.next != null)
                        newNode.next = head.next;
                    head.next = newNode;
                }
            }
        }
        performPrinting(bucket);
    }

    static void performPrinting(TreeMap<Integer, Node> map) {
        for (Map.Entry<Integer, Node> mapEntry : map.entrySet()) {
            Node head = mapEntry.getValue();
            while (head != null) {
                System.out.print(head.value + " ");
                head = head.next;
            }
        }
    }

    static int findBucket(int value) {
        while (value / 10 != 0) {
            value /= 10;
        }
        return value;
    }

    static Node properPlace(Node head, int newValue) {
        while (head.next != null) {
            if (head.next.value > newValue)
                break;
            head = head.next;
        }
        return head;
    }

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
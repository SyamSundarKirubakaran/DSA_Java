package problems.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SYAM K
 * @problem : Merge K sorted LL of size N into single Sorted LL of size kn - Better complexity
 */
public class Seventeen {

    public static void main(String[] args) {
        Node.SLLNode[] arr = new Node.SLLNode[]{
                new Node().constructHigherOrderEvenLengthLLOne(),
                new Node().constructHigherOrderEvenLengthLLTwo(),
                new Node().constructBasicEvenLengthLL(),
                new Node().constructBasicOddLengthLL()
        };
        Node.SLLNode result = mergeKSortedList(arr, arr.length - 1);
        new Node().printSLL(result);
    }

    private static Node.SLLNode mergeKSortedList(Node.SLLNode[] arr, int k) {
        Node.SLLNode head = null, last = null;
        PriorityQueue<Node.SLLNode> pq = new PriorityQueue<>(new Comparator<Node.SLLNode>() {
            @Override
            public int compare(Node.SLLNode o1, Node.SLLNode o2) {
                return o1.value - o2.value;
            }
        });

        for (int i = 0; i <= k; i++) {
            if (arr[i] != null) {
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()) {
            Node.SLLNode top = pq.peek();
            pq.remove();

            if (top.next != null) {
                pq.add(top.next);
            }

            if (head == null) {
                head = top;
            } else {
                last.next = top;
            }
            last = top;
        }
        return head;
    }

}

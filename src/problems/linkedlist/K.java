package problems.linkedlist;

/**
 * @author SYAM K
 * @problem : Merge K sorted LL of size N into single Sorted LL of size kn
 */
public class K {

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

    private static Node.SLLNode mergeSortedList(Node.SLLNode list1, Node.SLLNode list2) {
        Node.SLLNode result;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.value <= list2.value) {
            result = list1;
            result.next = mergeSortedList(list1.next, list2);
        } else {
            result = list2;
            result.next = mergeSortedList(list1, list2.next);
        }
        return result;
    }

    private static Node.SLLNode mergeKSortedList(Node.SLLNode[] arr, int last) {
        while (last != 0) {
            int i = 0, j = last;
            while (i < j) {
                arr[i] = mergeSortedList(arr[i], arr[j]);
                i += 1;
                j -= 1;
                if (i >= j)
                    last = j;
            }
        }
        return arr[0];
    }

}

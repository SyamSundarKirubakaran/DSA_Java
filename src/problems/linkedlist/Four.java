package problems.linkedlist;

/**
 * @author SYAM K
 * @problem : Detect Loop in LL
 */
public class Four {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().constructBasicEvenLengthLLWithLoop();
        System.out.print(detectLoop(head) + " ");
    }

    private static boolean detectLoop(Node.SLLNode head) {
        Node.SLLNode slowPtr = head;
        Node.SLLNode fastPtr = head;
        boolean flag = false;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (fastPtr == slowPtr) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}

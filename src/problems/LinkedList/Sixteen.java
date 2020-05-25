package problems.LinkedList;

/**
 * @author SYAM K
 * @problem : Add 1 to number represented as LL
 */
public class Sixteen {

    public static void main(String[] args) {
        Node.SLLNode head = new Node().number();
        Node.SLLNode result = addOne(head);
        new Node().printSLL(result);
    }

    private static Node.SLLNode addOne(Node.SLLNode head) {
        Node.SLLNode mainHead = reverse(head);
        Node.SLLNode copy = mainHead;
        Node.SLLNode temp = mainHead;

        int carry = 1, sum;
        while (mainHead != null) {
            sum = carry + mainHead.value;
            carry = (sum == 10) ? 1 : 0;
            sum = sum % 10;
            mainHead.value = sum;
            temp = mainHead;
            mainHead = mainHead.next;
        }

        if (carry > 0)
            temp.next = new Node.SLLNode(carry);

        return reverse(copy);
    }

    private static Node.SLLNode reverse(Node.SLLNode head) {
        if (head == null || head.next == null) return head;
        Node.SLLNode prev = null;
        Node.SLLNode current = head;
        Node.SLLNode upcoming;
        while (current != null) {
            upcoming = current.next;
            current.next = prev;
            prev = current;
            current = upcoming;
        }
        return prev;
    }


}

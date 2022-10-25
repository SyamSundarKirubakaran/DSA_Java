package workout;

// https://leetcode.com/problems/add-two-numbers/

public class A {

    public static void main(String[] args) {
        // construct list node one
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        // construct list node two
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(4);
        four.next = five;
        five.next = six;

        printLL(addTwoNumbers(one, four));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

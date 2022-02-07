package problems.dp;

/**
 * @author SYAM K
 * @problem : Largest Sum Independent set in a Binary Tree
 */
public class Ten {

    public static void main(String[] args) {
        Node head = constructTree();
        System.out.println(largestIndependentSet(head));
    }

    private static int largestIndependentSet(Node head) {
        if (head == null) return 0;
        if (head.lis != -1) return head.lis;
        if (head.left == null && head.right == null) {
            head.lis = head.value;
            return head.lis;
        }
        int exclude = largestIndependentSet(head.left) + largestIndependentSet(head.right);
        int include = head.value;
        if (head.left != null) {
            include += largestIndependentSet(head.left.left) + largestIndependentSet(head.left.right);
        }
        if (head.right != null) {
            include += largestIndependentSet(head.right.left) + largestIndependentSet(head.right.right);
        }
        return Math.max(include, exclude);
    }

    private static Node constructTree() {
        Node head = new Node(5);
        Node one = new Node(10);
        Node two = new Node(6);
        Node three = new Node(4);
        Node four = new Node(3);
        Node five = new Node(15);
        Node six = new Node(1);
        Node seven = new Node(11);
        Node eight = new Node(6);
        head.left = one;
        head.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        three.left = seven;
        four.left = eight;
        return head;
    }

    public static class Node {
        int value, lis;
        Node left, right;

        Node(int value) {
            this.value = value;
            lis = -1;
            left = null;
            right = null;
        }
    }

}

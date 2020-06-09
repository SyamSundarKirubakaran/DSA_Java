package problems.dp;

/**
 * @author SYAM K
 * @problem : Given a BT, find Largest Independent Set
 */
public class TwentyFive {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        Node head = constructTree();
        System.out.println(lis(head));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static int lis(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.lis != -1)
            return node.lis;
        if (node.left == null && node.right == null) {
            node.lis = 1;
            return node.lis;
        }
        int lisExclude = lis(node.left) + lis(node.right);
        int lisInclude = 1;
        if (node.left != null) {
            lisInclude += lis(node.left.left) + lis(node.left.right);
        }
        if (node.right != null) {
            lisInclude += lis(node.right.left) + lis(node.right.right);
        }
        node.lis = Math.max(lisExclude, lisInclude);
        return node.lis;
    }

    private static Node constructTree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        seven.left = eight;
        seven.right = nine;
        return one;
    }

    static class Node {
        int value;
        int lis;
        Node left, right;

        Node(int value) {
            this.value = value;
            lis = -1;
            left = null;
            right = null;
        }
    }

}

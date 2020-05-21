package problems.trees;

/**
 * @author SYAM K
 * @problem : Reference Node for Tree Problems
 */
public class Node {
    int value;
    Node left, right;

    Node() {
    }

    Node(int data) {
        value = data;
        left = null;
        right = null;
    }

    Node constructBalancedTree() {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        zero.left = one;
        zero.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        return zero;
    }

    Node constructUnBalancedTreeLeft() {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        zero.left = one;
        zero.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        three.left = seven;
        return zero;
    }

    Node constructUnBalancedTreeRight() {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        zero.left = one;
        zero.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        six.right = seven;
        return zero;
    }

}

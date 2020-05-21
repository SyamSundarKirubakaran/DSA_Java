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

    Node constructBalancedBST() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        four.left = two;
        two.left = one;
        two.right = three;
        four.right = six;
        six.left = five;
        six.right = seven;
        return four;
    }

    Node constructSumTree() {
        Node zero = new Node(50);
        Node one = new Node(15);
        Node two = new Node(10);
        Node three = new Node(10);
        Node four = new Node(5);
        Node five = new Node(7);
        Node six = new Node(3);
        zero.left = one;
        zero.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        return zero;
    }

    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.value + " ");
        }
    }

}

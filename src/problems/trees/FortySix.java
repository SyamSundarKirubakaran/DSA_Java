package problems.trees;

/**
 * @author SYAM K
 * @problem : Threaded BT
 */
public class FortySix {

    public static void main(String[] args) {
        ThreadedNode node = constructThreadedTree();
        printThreadedTree(node);
    }

    private static void printThreadedTree(ThreadedNode node) {
        ThreadedNode current = leftMost(node);
        while (current != null) {
            System.out.print(current.value + " ");
            if (current.isRightThread)
                current = current.right;
            else
                current = leftMost(current.right);
        }
    }

    private static ThreadedNode leftMost(ThreadedNode node) {
        if (node == null) return null;
        while (node.left != null)
            node = node.left;
        return node;
    }

    private static ThreadedNode constructThreadedTree() {
        ThreadedNode zero = new ThreadedNode(0);
        ThreadedNode one = new ThreadedNode(1);
        ThreadedNode two = new ThreadedNode(2);
        ThreadedNode three = new ThreadedNode(3);
        ThreadedNode four = new ThreadedNode(4);
        ThreadedNode five = new ThreadedNode(5);
        ThreadedNode six = new ThreadedNode(6);
        zero.left = one;
        one.left = three;
        three.right = one;
        three.isRightThread = true;
        one.right = four;
        four.right = zero;
        four.isRightThread = true;
        zero.right = two;
        two.left = five;
        five.right = two;
        five.isRightThread = true;
        two.right = six;
        return zero;
    }

    static class ThreadedNode {
        int value;
        ThreadedNode left, right;
        boolean isRightThread; // Tells if `right` is the right child or the thread

        ThreadedNode(int value) {
            this.value = value;
            left = null;
            right = null;
            isRightThread = false;
        }
    }

}

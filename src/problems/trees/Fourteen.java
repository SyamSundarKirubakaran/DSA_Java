package problems.trees;

/**
 * @author SYAM K
 * @problem : Sum Tree or not
 */
public class Fourteen {

    public static void main(String[] args) {
        Node head = new Node().constructSumTree();
        System.out.print(checkSumTree(head) + " ");
    }

    private static boolean checkSumTree(Node node) {
        int sumLeft, sumRight;
        if (node == null || isLeaf(node))
            return true;
        if (checkSumTree(node.left) && checkSumTree(node.right)) {
            if (node.left == null)
                sumLeft = 0;
            else if (isLeaf(node.left))
                sumLeft = node.left.value;
            else
                sumLeft = 2 * node.left.value;
            if (node.right == null)
                sumRight = 0;
            else if (isLeaf(node.right))
                sumRight = node.right.value;
            else
                sumRight = 2 * node.right.value;
            return node.value == sumLeft + sumRight;
        }
        return false;
    }

    private static boolean isLeaf(Node node) {
        if (node == null)
            return false;
        return node.left == null && node.right == null;
    }
}

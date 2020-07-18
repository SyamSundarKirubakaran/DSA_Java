package problems.trees;

/**
 * @author SYAM K
 * @problem : BT to a BT that holds Child sum property
 */
public class Thirty {

    public static void main(String[] args) {
        Node node = new Node().constructBalancedTree();
        convertTree(node);
        new Node().preOrderTraversal(node);
    }

    private static void convertTree(Node node) {
        int leftData = 0, rightData = 0, diff;
        if (node != null && !(node.left == null && node.right == null)) {
            convertTree(node.left);
            convertTree(node.right);
            if (node.left != null)
                leftData = node.left.value;
            if (node.right != null)
                rightData = node.right.value;
            diff = leftData + rightData - node.value;
            if (diff > 0) {
                node.value = node.value + diff;
            } else {
                increment(node, -diff);
            }
        }

    }

    private static void increment(Node node, int diff) {
        if (node != null) {
            if (node.left != null) {
                node.left.value = node.left.value + diff;
                increment(node.left, diff);
            } else if (node.right != null) {
                node.right.value = node.right.value + diff;
                increment(node.right, diff);
            }
        }
    }

}

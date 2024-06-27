package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Cousin Nodes or not
 */
public class T {

    private static Node parent = null;

    public static void main(String[] args) {
        Node node = new Node().constructBalancedTree();
        Node one = new Node(4);
        Node two = new Node(5);
        System.out.print(cousin(node, one, two));
    }

    private static boolean cousin(Node node, Node one, Node two) {
        return (level(node, one, 1) == level(node, two, 1)) && !sibling(node, one, two);
    }

    private static boolean sibling(Node node, Node one, Node two) {
        if (node.left == null || node.right == null)
            return false;
        return ((node.left.value == one.value && node.right.value == two.value) ||
                (node.right.value == one.value && node.left.value == two.value) ||
                sibling(node.left, one, two) ||
                sibling(node.right, one, two));
    }

    private static int level(Node node, Node searchNode, int level) {
        if (node == null)
            return 0;
        if (node.value == searchNode.value)
            return level;
        int left = level(node.left, searchNode, level + 1);
        if (left != 0)
            return left;
        else
            return level(node.right, searchNode, level + 1);
    }

}

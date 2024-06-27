package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Diameter of the Binary Tree
 */
public class H {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        System.out.println(diameter(head, new Height(0)));
    }

    private static int diameter(Node node, Height height) {
        Height leftHeight = new Height(0), rightHeight = new Height(0);
        if (node == null) {
            height.height = 0;
            return 0;
        }
        int leftDiameter = diameter(node.left, leftHeight);
        int rightDiameter = diameter(node.right, rightHeight);
        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;
        return Math.max((leftHeight.height + rightHeight.height + 1), Math.max(leftDiameter, rightDiameter));
    }

    static class Height {
        int height;

        Height(int value) {
            height = value;
        }
    }

}

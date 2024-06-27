package problems.trees;

import problems.trees.util.Node;

/**
 * @author SYAM K
 * @problem : Custom Tree Print Problem
 */
public class ZS {

    public static void main(String[] args) {
        Node node = new Node().constructBalancedTree();
        printTree(node, "");
    }

    private static void printTree(Node node, String indent) {
        if (node != null) {
            System.out.println(indent + " --> " + node.value);
            printTree(node.left, indent + " |");
            printTree(node.right, indent + " |");
        }
    }

}

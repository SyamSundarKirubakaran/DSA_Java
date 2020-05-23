package problems.trees;

/**
 * @author SYAM K
 * @problem : Reverse Alternate Levels of a perfect BT
 */
public class FortyFour {

    public static void main(String[] args) {
        Node node = new Node().constructBalancedTree();
        new Node().preOrderTraversal(node);
        reverseAlternateLevels(node.left, node.right, 2);
        System.out.println();
        new Node().preOrderTraversal(node);
    }

    private static void reverseAlternateLevels(Node node1, Node node2, int level) {
        if (node1 == null || node2 == null)
            return;
        if (level % 2 == 0) {
            int temp = node1.value;
            node1.value = node2.value;
            node2.value = temp;
        }
        reverseAlternateLevels(node1.left, node2.right, level + 1);
        reverseAlternateLevels(node1.right, node2.left, level + 1);
    }


}

package problems.trees;

/**
 * @author SYAM K
 * @problem : Find the level of a given node
 */
public class I {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        System.out.println(findLevel(head, 1, 6));
    }

    private static int findLevel(Node node, int level, int key) {
        if (node == null)
            return -1;
        if (node.value == key) {
            return level;
        }
        int leftLevel = findLevel(node.left, level + 1, key);
        if (leftLevel != -1) return leftLevel;
        return findLevel(node.right, level + 1, key);
    }
}

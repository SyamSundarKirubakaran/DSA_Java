package problems.trees;

/**
 * @author SYAM K
 * @problem : Balanced BST construction from a sorted List
 */
public class U {

    private static int[] list = new int[]{5, 10, 20, 30, 40, 50, 60};

    public static void main(String[] args) {
        Node node = performConstruction(list, 0, list.length - 1);
        new Node().preOrderTraversal(node);
    }

    private static Node performConstruction(int[] list, int start, int end) {
        if (start > end)
            return null;
        int middle = (start + end) / 2;
        Node node = new Node(list[middle]);
        node.left = performConstruction(list, start, middle - 1);
        node.right = performConstruction(list, middle + 1, end);
        return node;
    }


}

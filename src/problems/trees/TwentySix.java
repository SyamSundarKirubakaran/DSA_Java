package problems.trees;

/**
 * @author SYAM K
 * @problem : All nodes at K distance from leaf
 */
public class TwentySix {

    public static void main(String[] args) {
        Node node = new Node().constructBalancedTree();
        int[] path = new int[1000];
        boolean[] visited = new boolean[1000];
        findKDistanceFromLeaf(node, path, visited, 0, 1);
    }

    private static void findKDistanceFromLeaf(Node node, int[] path, boolean[] visited, int pathLength, int k) {
        if (node == null) return;
        path[pathLength] = node.value;
        visited[pathLength] = false;

        if (isLeaf(node) && (pathLength - k) >= 0 && !visited[pathLength - k]) {
            System.out.print(path[pathLength - k] + " ");
            visited[pathLength - k] = true;
        }

        findKDistanceFromLeaf(node.left, path, visited, pathLength + 1, k);
        findKDistanceFromLeaf(node.right, path, visited, pathLength + 1, k);
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}

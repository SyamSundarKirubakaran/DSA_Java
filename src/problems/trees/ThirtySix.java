package problems.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SYAM K
 * @problem : Tree from ancestor Matrix
 */
public class ThirtySix {

    private static int[][] ancestorMatrix = {
            {0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};

    public static void main(String[] args) {
        Node result = constructTree();
        new Node().preOrderTraversal(result);
    }

    private static Node constructTree() {
        int[] index = new int[ancestorMatrix.length];
        int[] count = new int[ancestorMatrix.length];
        int maintainer;
        for (int i = 0; i < ancestorMatrix.length; i++) {
            maintainer = 0;
            for (int j = 0; j < ancestorMatrix.length; j++) {
                if (ancestorMatrix[i][j] == 1)
                    maintainer += 1;
            }
            index[i] = i;
            count[i] = maintainer;
        }
        performMergeSort(count, 0, count.length - 1, index);
        boolean[] alreadyFilled = new boolean[ancestorMatrix.length];
        for (int i = 0; i < ancestorMatrix.length; i++) {
            alreadyFilled[i] = false;
        }
        return constructBinaryTree(index, count, alreadyFilled);
    }

    private static Node constructBinaryTree(int[] index, int[] count, boolean[] alreadyFilled) {
        List<Integer> oldList = new LinkedList<>();
        List<Integer> indexes;
        List<Node> nodeList = new LinkedList<>();
        Node node = null;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                indexes = findOneIndexes(index[i], count.length);
                indexes.removeAll(oldList);
                if (indexes.size() > 2) {
                    System.out.print("Invalid Input");
                    break;
                } else {
                    node = new Node(index[i]);
                    Node leftNode = null, rightNode = null;
                    boolean isSizeTwo = indexes.size() == 2;
                    for (Node n : nodeList) {
                        if (n.value == indexes.get(0))
                            leftNode = n;
                        if (isSizeTwo && n.value == indexes.get(1))
                            rightNode = n;
                    }
                    if (leftNode == null)
                        node.left = new Node(indexes.get(0));
                    else
                        node.left = leftNode;
                    if (indexes.size() == 2) {
                        if (rightNode == null)
                            node.right = new Node(indexes.get(1));
                        else
                            node.right = rightNode;
                    }
                    nodeList.add(node);
                    nodeList.add(node.left);
                    if (indexes.size() == 2)
                        nodeList.add(node.right);
                }
                oldList.addAll(indexes);
            }
        }
        return node;
    }

    private static List<Integer> findOneIndexes(int index, int maxSize) {
        List<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < maxSize; i++) {
            if (ancestorMatrix[index][i] == 1)
                indexes.add(i);
        }
        return indexes;
    }

    private static void performMergeSort(int[] count, int start, int end, int[] index) {
        if (start < end) {
            int middle = (start + end) / 2;
            performMergeSort(count, start, middle, index);
            performMergeSort(count, middle + 1, end, index);
            performMergeProcedure(count, start, middle, end, index);
        }
    }

    private static void performMergeProcedure(int[] count, int start, int middle, int end, int[] index) {
        int lc = middle - start + 2;
        int rc = end - (middle + 1) + 2;

        int[] la = new int[lc];
        int[] ra = new int[rc];

        int[] ila = new int[lc];
        int[] ira = new int[rc];

        int j = 0;
        for (int i = start; i <= middle; i++) {
            la[j] = count[i];
            j++;
        }
        la[lc - 1] = Integer.MAX_VALUE;

        j = 0;
        for (int i = start; i <= middle; i++) {
            ila[j] = index[i];
            j++;
        }
        ila[lc - 1] = Integer.MAX_VALUE;

        j = 0;
        for (int i = middle + 1; i <= end; i++) {
            ra[j] = count[i];
            j++;
        }
        ra[rc - 1] = Integer.MAX_VALUE;

        j = 0;
        for (int i = middle + 1; i <= end; i++) {
            ira[j] = index[i];
            j++;
        }
        ira[rc - 1] = Integer.MAX_VALUE;

        int lp = 0, rp = 0;
        for (int i = start; i <= end; i++) {
            if (la[lp] < ra[rp]) {
                count[i] = la[lp];
                index[i] = ila[lp];
                lp += 1;
            } else {
                count[i] = ra[rp];
                index[i] = ira[rp];
                rp += 1;
            }
        }

    }

}

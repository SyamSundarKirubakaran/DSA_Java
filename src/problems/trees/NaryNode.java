package problems.trees;

/**
 * @author SYAM K
 * @problem : n-ary tree
 */
public class NaryNode {

    void preOrderTraversal(NNode nnode) {
        if (nnode != null) {
            System.out.print(nnode.value + " ");
            for (NNode child : nnode.children) {
                preOrderTraversal(child);
            }
        }
    }

    void inOrderTraversal(NNode nnode) {
        if (nnode != null) {
            int total = nnode.children.length;
            for (int i = 0; i < total - 1; i++)
                inOrderTraversal(nnode.children[i]);
            System.out.print(" " + nnode.value + " ");
            if (total > 0)
                inOrderTraversal(nnode.children[total - 1]); // print parent node just before the last node
        }
    }

    NNode inflateNaryTree() {
        NNode root = new NNode(3, 0);
        root.children[0] = new NNode(3, 1);
        root.children[1] = new NNode(0, 2);
        root.children[2] = new NNode(0, 3);
        root.children[0].children[0] = new NNode(0, 4);
        root.children[0].children[1] = new NNode(0, 5);
        root.children[0].children[2] = new NNode(0, 6);
        return root;
    }

    static class NNode {
        int value;
        NNode[] children;

        NNode(int n, int value) {
            children = new NNode[n];
            this.value = value;
        }
    }

}

package problems.trees;

import problems.trees.util.NaryNode;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Serialization and Deserialization n-ary Tree
 */
public class ZI {

    private static LinkedList<NaryNode.NNode> serialResult = new LinkedList<>();

    public static void main(String[] args) {
        NaryNode.NNode node = new NaryNode().inflateNaryTree();
        serialize(node);
        for (NaryNode.NNode value : serialResult) {
            System.out.print(value.value + " ");
        }
        System.out.println();
        NaryNode.NNode result = deserialize(serialResult);
        new NaryNode().preOrderTraversal(result);
    }

    private static NaryNode.NNode deserialize(LinkedList<NaryNode.NNode> serialResult) {
        NaryNode.NNode node = null;
        if (serialResult.size() > 0) {
            NaryNode.NNode popped = serialResult.removeFirst();
            if (popped.value != -1)
                node = popped;
            else
                node = null;
            deserialize(serialResult);
        }
        return node;
    }

    private static void serialize(NaryNode.NNode node) {
        if (node == null)
            serialResult.addLast(new NaryNode.NNode(0, -1));
        else {
            serialResult.addLast(node);
            for (NaryNode.NNode child : node.children) {
                serialize(child);
                serialize(null);
            }
        }
    }

}

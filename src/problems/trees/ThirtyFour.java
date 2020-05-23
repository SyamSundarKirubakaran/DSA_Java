package problems.trees;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Serialization and Deserialization BT
 */
public class ThirtyFour {

    // END MARKER = -1
    private static LinkedList<Node> serialResult = new LinkedList<>();

    public static void main(String[] args) {
        Node node = new Node().constructBalancedTree();
        serialize(node);
        for (Node value : serialResult) {
            System.out.print(value.value + " ");
        }
        System.out.println();
        Node result = deserialize(serialResult);
        new Node().preOrderTraversal(result);
    }

    private static Node deserialize(LinkedList<Node> serialResult) {
        Node node = null;
        if (serialResult.size() > 0) {
            Node popped = serialResult.removeFirst();
            if (popped.value != -1)
                node = popped;
            else
                node = null;
            deserialize(serialResult);
        }
        return node;
    }

    private static void serialize(Node node) {
        if (node == null)
            serialResult.addLast(new Node(-1));
        else {
            serialResult.addLast(node);
            serialize(node.left);
            serialize(node.right);
        }
    }

}

package problems.trees;

/**
 * @author SYAM K
 * @problem : Expression Evaluation
 */
public class ZA {

    public static void main(String[] args) {
        Node node = inflateTree();
        System.out.print(evaluateExpression(node));
    }

    private static String evaluateExpression(Node node) {
        if (node == null) return "!";
        if (!node.value.equals("*") && !node.value.equals("+") && !node.value.equals("!"))
            return node.value;
        String left = evaluateExpression(node.left);
        String right = evaluateExpression(node.right);
        switch (node.value) {
            case "+":
                node.value = ((Integer.parseInt(left) + Integer.parseInt(right)) + "");
                break;
            case "*":
                node.value = ((Integer.parseInt(left) * Integer.parseInt(right)) + "");
                break;
        }
        return node.value;
    }

    private static Node inflateTree() {
        Node root = new Node("+");
        Node one = new Node("*");
        Node two = new Node("*");
        Node three = new Node("1");
        Node four = new Node("2");
        Node five = new Node("3");
        Node six = new Node("4");
        root.left = one;
        root.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        return root;
    }

    public static class Node {
        String value;
        Node left, right;

        Node(String symbol) {
            value = symbol;
            left = null;
            right = null;
        }
    }
}

package problems.trees;

import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Spiral Level Order Traversal
 */
public class X {

    private static Stack<Node> s1 = new Stack<>();
    private static Stack<Node> s2 = new Stack<>();

    public static void main(String[] args) {
        Node node = new Node().constructBalancedTree();
        printSpiral(node);
    }

    private static void printSpiral(Node node) {
        if (node != null) {
            s1.push(node);
            while (!s1.isEmpty() || !s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    Node popped = s1.pop();
                    System.out.print(popped.value + " ");
                    if (popped.right != null)
                        s2.push(popped.right);
                    if (popped.left != null)
                        s2.push(popped.left);
                }
                while (!s2.isEmpty()) {
                    Node popped = s2.pop();
                    System.out.print(popped.value + " ");
                    if (popped.left != null)
                        s1.push(popped.left);
                    if (popped.right != null)
                        s1.push(popped.right);
                }
            }
        }
    }
}

package problems.trees;

/**
 * @author SYAM K
 * @problem : Check if removing an edge will cut into two equal halves
 */
public class FortyTwo {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        int result = findTreeSum(head);
        preOrderFind(head, result);
    }

    private static void preOrderFind(Node head, int result) {
        if (head == null) return;
        if (2 * head.value == result) {
            System.out.print(true);
            return;
        }
        preOrderFind(head.left, result);
        preOrderFind(head.right, result);
    }

    private static int findTreeSum(Node head) {
        if (head == null) return 0;
        int left = findTreeSum(head.left);
        int right = findTreeSum(head.right);
        head.value = 1 + left + right;
        return head.value;
    }

}

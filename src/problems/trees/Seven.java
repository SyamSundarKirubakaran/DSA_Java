package problems.trees;

/**
 * @author SYAM K
 * @problem : Binary Tree into DLL - IN order - InPlace conversion
 */
public class Seven {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        Node result = convertToDLL(head);
        while (result.left != null) {
            result = result.left;
        }
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.right;
        }
    }

    private static Node convertToDLL(Node head) {
        if (head == null) return null;
        if (head.left != null) {
            Node leftTree = convertToDLL(head.left);
            while (leftTree.right != null) {
                leftTree = leftTree.right;
            }
            leftTree.right = head;
            head.left = leftTree;
        }
        if (head.right != null) {
            Node rightTree = convertToDLL(head.right);
            while (rightTree.left != null) {
                rightTree = rightTree.left;
            }
            rightTree.left = head;
            head.right = rightTree;
        }
        return head;
    }

}

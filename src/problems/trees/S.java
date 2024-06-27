package problems.trees;

/**
 * @author SYAM K
 * @problem : One BT is a sub tree of another BT or not
 */
public class S {

    public static void main(String[] args) {
        Node head = new Node().constructBalancedTree();
        Node smallerHead = new Node().constructSmallBalancedTree();
        System.out.print(subTree(head, smallerHead));
    }

    private static boolean subTree(Node head, Node smallerHead) {
        if (smallerHead == null)
            return true;
        if (head == null)
            return false;
        if (identical(head, smallerHead))
            return true;
        return subTree(head.left, smallerHead) || subTree(head.right, smallerHead);
    }

    private static boolean identical(Node head, Node smallerHead) {
        if (head == null && smallerHead == null)
            return true;
        if (head == null || smallerHead == null)
            return false;
        return head.value == smallerHead.value && identical(head.left, smallerHead.left) && identical(head.right, smallerHead.right);
    }

}

package problems.trees;

/**
 * @author SYAM K
 * @problem : Locking and Unlocking a Node - Design Problem ->
 * lock -> all parents should be unlocked before lock and all children will be locked after lock
 * unlock -> all parents should be unlocked before lock and all children will be unlocked after unlock
 */
public class FortyThree {

    public static void main(String[] args) {
        CustomNode node = constructBalancedTree();
        lock(node, 1);
        printPreOrderLock(node);
        unlock(node, 1);
        System.out.println();
        printPreOrderLock(node);
    }

    private static void unlock(CustomNode node, int k) {
        if (node != null) {
            if (node.value == k && node.isLocked) {
                node.isLocked = false;
                lockChildren(node, false);
            }
            unlock(node.left, k);
            unlock(node.right, k);
        }
    }

    private static void printPreOrderLock(CustomNode node) {
        if (node != null) {
            System.out.println(node.isLocked);
            printPreOrderLock(node.left);
            printPreOrderLock(node.right);
        }
    }

    private static void lock(CustomNode node, int k) {
        if (node != null) {
            if (node.value == k && !node.isLocked) {
                node.isLocked = true;
                lockChildren(node, true);
            }
            lock(node.left, k);
            lock(node.right, k);
        }
    }

    private static void lockChildren(CustomNode node, boolean assign) {
        if (node != null) {
            node.isLocked = assign;
            lockChildren(node.left, assign);
            lockChildren(node.right, assign);
        }
    }

    private static CustomNode constructBalancedTree() {
        CustomNode zero = new CustomNode(0);
        CustomNode one = new CustomNode(1);
        CustomNode two = new CustomNode(2);
        CustomNode three = new CustomNode(3);
        CustomNode four = new CustomNode(4);
        CustomNode five = new CustomNode(5);
        CustomNode six = new CustomNode(6);
        zero.left = one;
        zero.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        return zero;
    }

    static class CustomNode {
        int value;
        CustomNode left, right;
        boolean isLocked;

        CustomNode(int value) {
            this.value = value;
            left = null;
            right = null;
            isLocked = false;
        }
    }

}

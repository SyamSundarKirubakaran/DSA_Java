package generic_workout.company.workout;


public class Temp {

    public static void main(String[] args) {
        Node one = new Node(20);
        Node two = new Node(9);
        Node three = new Node(25);
        Node four = new Node(5);
        Node five = new Node(12);
        Node six = new Node(11);
        Node seven = new Node(14);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        five.left = six;
        five.right = seven;

        int value = 9;

        printInOrder(one, value);
    }

    private static boolean outputReceived = false;

    private static void printInOrder(Node node, int value) {
        if(node == null || outputReceived) return;
        printInOrder(node.left, value);
        if(node.value > value && !outputReceived) {
            System.out.println(node.value);
            outputReceived = true;
        }
        printInOrder(node.right, value);
    }


    public static class Node {
        int value;
        Node left, right;

        Node(int nodeValue) {
            value = nodeValue;
            left = null;
            right = null;
        }
    }

}

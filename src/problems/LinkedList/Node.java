package problems.LinkedList;

import javafx.util.Pair;

/**
 * @author SYAM K
 * @problem : Singly Linked List Node
 */
public class Node {

    SLLNode constructBasicEvenLengthLL() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(3);
        SLLNode four = new SLLNode(4);
        SLLNode five = new SLLNode(5);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return zero;
    }

    SLLNode zerosOnesTwosLL() {
        SLLNode zero = new SLLNode(1);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(0);
        SLLNode three = new SLLNode(2);
        SLLNode four = new SLLNode(2);
        SLLNode five = new SLLNode(0);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return zero;
    }

    SLLNode constructBasicUnSortedEvenLengthLL() {
        SLLNode zero = new SLLNode(4);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(10);
        SLLNode three = new SLLNode(0);
        SLLNode four = new SLLNode(4);
        SLLNode five = new SLLNode(5);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return zero;
    }

    SLLNode constructHigherOrderEvenLengthLLOne() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(2);
        SLLNode two = new SLLNode(4);
        SLLNode three = new SLLNode(6);
        SLLNode four = new SLLNode(8);
        SLLNode five = new SLLNode(10);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return zero;
    }

    SLLNode constructHigherOrderEvenLengthLLTwo() {
        SLLNode zero = new SLLNode(1);
        SLLNode one = new SLLNode(3);
        SLLNode two = new SLLNode(5);
        SLLNode three = new SLLNode(7);
        SLLNode four = new SLLNode(7);
        SLLNode five = new SLLNode(11);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return zero;
    }

    SLLNode constructEvenLengthPalindromeLL() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(2);
        SLLNode four = new SLLNode(1);
        SLLNode five = new SLLNode(0);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return zero;
    }

    SLLNode constructOddLengthPalindromeLL() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(1);
        SLLNode four = new SLLNode(0);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        return zero;
    }

    SLLNode constructBasicEvenLengthLLWithLoop() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(3);
        SLLNode four = new SLLNode(4);
        SLLNode five = new SLLNode(5);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = two;
        return zero;
    }

    SLLNode constructBasicOddLengthLL() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(3);
        SLLNode four = new SLLNode(4);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        return zero;
    }

    Pair<SLLNode, SLLNode> constructMergingListAtANodeEqual() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(3);
        SLLNode four = new SLLNode(4);
        SLLNode five = new SLLNode(5);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        SLLNode six = new SLLNode(6);
        SLLNode seven = new SLLNode(7);
        SLLNode eight = new SLLNode(8);
        six.next = seven;
        seven.next = eight;
        eight.next = three;
        return new Pair<>(zero, six);
    }

    Pair<SLLNode, SLLNode> constructMergingListAtANodeNotEqual() {
        SLLNode zero = new SLLNode(0);
        SLLNode one = new SLLNode(1);
        SLLNode two = new SLLNode(2);
        SLLNode three = new SLLNode(3);
        SLLNode four = new SLLNode(4);
        SLLNode five = new SLLNode(5);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        SLLNode six = new SLLNode(6);
        SLLNode seven = new SLLNode(7);
        six.next = seven;
        seven.next = three;
        return new Pair<>(zero, six);
    }

    void printSLL(SLLNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public SLLNode number() {
        SLLNode zero = new SLLNode(5);
        SLLNode one = new SLLNode(9);
        SLLNode two = new SLLNode(3);
        SLLNode three = new SLLNode(9);
        SLLNode four = new SLLNode(9);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        return zero;
    }

    static class SLLNode {
        int value;
        SLLNode next;

        SLLNode(int value) {
            this.value = value;
            next = null;
        }
    }

    CustomNode constructCustomLLWithRandom() {
        CustomNode one = new CustomNode(10);
        CustomNode two = new CustomNode(20);
        CustomNode three = new CustomNode(30);
        CustomNode four = new CustomNode(40);
        one.next = two;
        two.next = three;
        three.next = four;
        one.random = three;
        two.random = four;
        three.random = two;
        four.random = one;
        return one;
    }

    void printCustomLL(CustomNode head) {
        while (head != null) {
            System.out.print(head.value + "(" + head.random.value + ") ");
            head = head.next;
        }
    }

    static class CustomNode {
        int value;
        CustomNode next, random;

        CustomNode(int value) {
            this.value = value;
            next = null;
            random = null;
        }
    }

}

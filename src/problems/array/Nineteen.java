package problems.array;

import java.util.LinkedList;

/**
 * @author SYAM K
 * @problem : Largest Multiple of 3 with given digits.
 */
public class Nineteen {

    static int[] arr = new int[]{3, 3, 6, 1, 1};

    public static void main(String[] args) {
        largestPossibleMultiple(arr, arr.length - 1);
    }

    private static void largestPossibleMultiple(int[] arr, int size) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        LinkedList<Integer> q3 = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i <= size; i++) {
            sum += arr[i];
            if (arr[i] % 3 == 0) {
                q1.addLast(arr[i]);
            } else if (arr[i] % 3 == 1) {
                q2.addLast(arr[i]);
            } else if (arr[i] % 3 == 2) {
                q3.addLast(arr[i]);
            }
        }
        if (sum % 3 == 1) {
            if (!q2.isEmpty()) {
                q2.removeFirst();
            } else {
                removeTwoElements(q3);
            }
        } else if (sum % 3 == 2) {
            if (!q3.isEmpty()) {
                q3.removeFirst();
            } else {
                removeTwoElements(q2);
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        inflateIntoSingleResult(result, q1, q2, q3);
        result.sort((o1, o2) -> o2 - o1);
        print(result);
    }

    private static void removeTwoElements(LinkedList<Integer> q) {
        int counter = 1;
        while (counter >= 0) {
            if (!q.isEmpty()) {
                q.removeFirst();
            }
            counter -= 1;
        }
    }

    private static void print(LinkedList<Integer> result) {
        for (int i = 0; i <= result.size() - 1; i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    private static void inflateIntoSingleResult(LinkedList<Integer> result,
                                                LinkedList<Integer> q1,
                                                LinkedList<Integer> q2,
                                                LinkedList<Integer> q3) {
        for (Integer value : q1) {
            result.addLast(value);
        }
        for (Integer value : q2) {
            result.addLast(value);
        }
        for (Integer value : q3) {
            result.addLast(value);
        }
    }

}

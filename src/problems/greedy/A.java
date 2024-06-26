package problems.greedy;

import java.util.PriorityQueue;

/**
 * @author SYAM K
 * @problem : n different ropes of different length, tie them up into a single rope with Min cost.
 */
public class A {

    private static final int[] arr = {2, 3, 5, 7, 9, 13};

    public static void main(String[] args) {
        

        perform(arr, arr.length);

        
    }

    private static void perform(int[] arr, int length) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : arr) {
            pq.add(a);
        }
        int cost = 0;
        int delOne, delTwo;
        while (pq.size() != 1) {
            delOne = pq.remove();
            delTwo = pq.remove();
            cost += delOne + delTwo;
            System.out.println("delOne: " + delOne + ", delTwo: " + delTwo + ", insert: " + (delOne + delTwo) + ", cost: " + cost);
            pq.add(delOne + delTwo);
            System.out.println(pq);
        }
        System.out.println(pq.remove());
    }

}

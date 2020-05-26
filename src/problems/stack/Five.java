package problems.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author SYAM K
 * @problem : Overlapping Intervals
 */
public class Five {

    private static int[] startIntervals = new int[]{6, 2, 1, 13, 9, 100};
    private static int[] endIntervals = new int[]{8, 5, 3, 20, 14, 120};

    private static Stack<Integer> startStack = new Stack<>();
    private static Stack<Integer> endStack = new Stack<>();

    public static void main(String[] args) {
        mergeOverlap(startIntervals, endIntervals, startIntervals.length - 1);
    }

    private static void mergeOverlap(int[] startIntervals, int[] endIntervals, int size) {
        mergeSort(startIntervals, endIntervals, 0, size);
        int start, end;
        startStack.push(startIntervals[0]);
        endStack.push(endIntervals[0]);
        for (int i = 1; i <= size; i++) {
            start = startStack.peek();
            end = endStack.peek();
            if (end < startIntervals[i]) {
                startStack.push(startIntervals[i]);
                endStack.push(endIntervals[i]);
            }
            if (end > startIntervals[i] && end < endIntervals[i]) {
                startStack.pop();
                endStack.pop();
                startStack.push(start);
                endStack.push(endIntervals[i]);
            }
        }
        System.out.print(Arrays.toString(startStack.toArray()));
        System.out.println();
        System.out.print(Arrays.toString(endStack.toArray()));
    }

    private static void mergeSort(int[] startIntervals, int[] endIntervals, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(startIntervals, endIntervals, start, middle);
            mergeSort(startIntervals, endIntervals, middle + 1, end);
            performMerging(startIntervals, endIntervals, start, middle, end);
        }
    }

    private static void performMerging(int[] startIntervals, int[] endIntervals, int start, int middle, int end) {
        int ls = middle - start + 2;
        int rs = end - (middle + 1) + 2;
        int[] la = new int[ls];
        int[] ra = new int[rs];
        int[] endla = new int[ls];
        int[] endra = new int[rs];

        int j = 0;
        for (int i = start; i <= middle; i++) {
            la[j] = startIntervals[i];
            endla[j] = endIntervals[i];
            j += 1;
        }
        la[ls - 1] = Integer.MAX_VALUE;
        endla[ls - 1] = Integer.MAX_VALUE;

        j = 0;
        for (int i = middle + 1; i <= end; i++) {
            ra[j] = startIntervals[i];
            endra[j] = endIntervals[i];
            j += 1;
        }
        ra[rs - 1] = Integer.MAX_VALUE;
        endra[rs - 1] = Integer.MAX_VALUE;

        int lp = 0, rp = 0;
        for (int i = start; i <= end; i++) {
            if (la[lp] <= ra[rp]) {
                startIntervals[i] = la[lp];
                endIntervals[i] = endla[lp];
                lp += 1;
            } else {
                startIntervals[i] = ra[rp];
                endIntervals[i] = endra[rp];
                rp += 1;
            }
        }
    }

}

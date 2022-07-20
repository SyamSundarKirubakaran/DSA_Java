package problems.heaps;

/**
 * @author SYAM K
 * @problem : Finding the max element in MIN heap
 */
public class One {

    public static void main(String[] args) {


        // Number of nodes
        int n = 10;

        // heap represents the following min heap:
        //     10
        //    / \
        //  25     23
        //  / \   / \
        // 45 50 30 35
        // / \ /
        //63 65 81
        int[] heap = {10, 25, 23, 45, 50, 30, 35, 63, 65, 81};

        System.out.println(findMaximumElement(heap, n));


    }

    private static int findMaximumElement(int[] heap, int n) {
        int maximumElement = heap[n / 2];

        for (int i = 1 + n / 2; i < n; ++i)
            maximumElement = Math.max(maximumElement, heap[i]);

        return maximumElement;
    }


}

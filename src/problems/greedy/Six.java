package problems.greedy;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Fractional Knapsack
 */
public class Six {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;

        double maxValue = getMaxValue(wt, val, capacity);
        System.out.println("Maximum value we can obtain = " +
                maxValue);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    private static double getMaxValue(int[] wt,
                                      int[] val, int capacity) {
        ItemValue[] iVal = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }

        Arrays.sort(iVal, (o1, o2) -> o2.cost.compareTo(o1.cost));


        double totalValue = 0d;

        for (ItemValue i : iVal) {

            int curWt = (int) i.wt;
            int curVal = (int) i.val;

            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;

            } else {
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }

        }

        return totalValue;
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double) (val / wt);
        }
    }

}

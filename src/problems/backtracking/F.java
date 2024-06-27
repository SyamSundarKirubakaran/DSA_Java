package problems.backtracking;

/**
 * @author SYAM K
 * @problem : Find subset of elements that are selected from a given set whose sum adds upto a given number `k` // Subset Sum Problem - Using Backtracking
 */
public class F {

    static int subsetCount = 0;

    // Subset Sum Problem - Using Backtracking
    public static void main(String[] args) {
        

        int[] list = {1, 3, 5, 2};
        subsetSum(list, 0, 0, 6);
        System.out.println(subsetCount);


    }

    static void subsetSum(int[] list, int sum, int startingIndex, int targetSum) {
        if (targetSum == sum) {
            subsetCount++;
            if (startingIndex < list.length)
                subsetSum(list, sum - list[startingIndex - 1], startingIndex, targetSum);
        } else {
            for (int i = startingIndex; i < list.length; i++) {
                subsetSum(list, sum + list[i], i + 1, targetSum);
            }
        }
    }
}

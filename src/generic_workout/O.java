package generic_workout;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combinations/description/

public class O {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    static List<List<Integer>> output = new LinkedList<>();
    static int nStat;
    static int kStat;

    public static void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == kStat)
            output.add(new LinkedList<>(curr));

        for (int i = first; i < nStat + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        nStat = n;
        kStat = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }

}

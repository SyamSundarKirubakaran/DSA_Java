package problems.company.tesla;

// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/

import java.util.ArrayList;
import java.util.List;

public class Y {

    class SparseVector {

        List<int[]> pairs;

        SparseVector(int[] nums) {
            pairs = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    pairs.add(new int[]{i, nums[i]});
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int result = 0, p = 0, q = 0;
            while (p < pairs.size() && q < vec.pairs.size()) {
                if (pairs.get(p)[0] == vec.pairs.get(q)[0]) {
                    result += pairs.get(p)[1] * vec.pairs.get(q)[1];
                    p++;
                    q++;
                }
                else if (pairs.get(p)[0] > vec.pairs.get(q)[0]) {
                    q++;
                }
                else {
                    p++;
                }
            }
            return result;
        }
    }

}

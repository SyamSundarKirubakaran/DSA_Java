package generic_workout.company.tesla.set1;

import java.util.Arrays;

// https://leetcode.com/problems/largest-perimeter-triangle/

public class G {


    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i + 1] > A[i + 2])
                return A[i] + A[i + 1] + A[i + 2];
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new G().largestPerimeter(new int[]{3, 6, 2, 3}));
    }

}

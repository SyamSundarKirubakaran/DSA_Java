package generic_workout.temp;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/minimum-time-difference/

public class D {

    public static void main(String[] args) {
        ArrayList<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");

        System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {

        boolean[] mark = new boolean[24 * 60];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;


        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            min = Math.min(min, h * 60 + m);
            max = Math.max(max, h * 60 + m);
            mark[h * 60 + m] = true;
        }

        int prev = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = min; i <= max; i++) {
            if (mark[i]) {
                if (i == min) {
                    // 0---min----max-----1440, so we have two directions to calculate the distance
                    minDiff = Math.min(minDiff, Math.min(max - min, 1440 - max + min));
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }

        return minDiff;
    }


}

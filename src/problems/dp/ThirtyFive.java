package problems.dp;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Weighted Job Scheduling
 */
public class ThirtyFive {

    private static final Job[] jobs = new Job[]{
            new Job(1, 4, 100),
            new Job(3, 4, 50),
            new Job(3, 6, 300),
            new Job(1, 2, 20),
    };

    public static void main(String[] args) {
        Long start = System.nanoTime();

        findMaxProfit(jobs, jobs.length);

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

//    private static Job[] jobs = new Job[]{
//            new Job(3, 10, 20),
//            new Job(1, 2, 50),
//            new Job(6, 19, 100),
//            new Job(2, 100, 200),
//    };

    private static void findMaxProfit(Job[] jobs, int length) {
        int profit, l;
        int[] table = new int[length];
        jobs = sort(ThirtyFive.jobs, length);
        table[0] = jobs[0].profit;
        System.out.println("After sort(jobs): " + Arrays.toString(jobs));
        for (int i = 1; i < length; i++) {
            profit = jobs[i].profit;
            l = latestNonConflict(jobs, i);
            if (l != -1) {
                profit += table[l];
            }
            table[i] = Math.max(profit, table[i - 1]);
        }
        System.out.println("Final(table): " + Arrays.toString(table));
        System.out.println(table[length - 1]);
    }

    private static int latestNonConflict(Job[] jobs, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (jobs[j].finish <= jobs[i].start) {
                return j;
            }
        }
        return -1;
    }

    private static Job[] sort(Job[] jobs, int length) {
        Job t;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - (i + 1); j++) {
                if (jobs[j].finish > jobs[j + 1].finish) {
                    t = jobs[j];
                    jobs[j] = jobs[j + 1];
                    jobs[j + 1] = t;
                }
            }
        }
        return jobs;
    }

    private static class Job {
        int start, finish, profit;

        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", finish=" + finish +
                    ", profit=" + profit +
                    '}';
        }
    }

}

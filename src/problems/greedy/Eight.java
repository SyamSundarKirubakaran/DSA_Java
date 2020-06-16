package problems.greedy;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author SYAM K
 * @problem : Job Sequencing with Deadlines
 */
public class Eight {

    public static void main(String[] args) {
        Long start = System.nanoTime();

        int n = 5;
        Job[] jobs = new Job[n];

        jobs[0] = new Job('a', 2, 100);
        jobs[1] = new Job('b', 1, 19);
        jobs[2] = new Job('c', 2, 27);
        jobs[3] = new Job('d', 1, 25);
        jobs[4] = new Job('e', 3, 15);

        printJobScheduling(jobs, n);
        System.out.println();

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    // Function to print job scheduling
    public static void printJobScheduling(Job[] jobs, int n) {

        Arrays.sort(jobs, (j1, j2) -> {
            if (j1.profit != j2.profit)
                return j2.profit - j1.profit;
            else
                return j2.deadline - j1.deadline;
        });

        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 0; i < n; i++)
            ts.add(i);

        for (int i = 0; i < n; i++) {
            Integer x = ts.floor(jobs[i].deadline - 1);

            if (x != null) {
                System.out.print(jobs[i].id + " ");
                ts.remove(x);
            }
        }
    }

    public static class Job {
        char id;
        int deadline;
        int profit;

        // Constructor
        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

}

package problems.greedy;

/**
 * @author SYAM K
 * @problem : Maximum Non Overlapping Intervals
 */
public class B {

    private static final Activity[] arr = new Activity[]{
            new Activity(10, 13),
            new Activity(9, 14),
            new Activity(7, 11),
            new Activity(12, 16),
            new Activity(20, 25),
            new Activity(1, 50)
    };

    public static void main(String[] args) {
        

        maxActivities(arr, arr.length);

        
    }

    private static void maxActivities(Activity[] activities, int length) {
        sort(activities, length);
        int i = 0;
        System.out.println("Start: " + activities[i].start + ", finish: " + activities[i].finish);
        for (int j = 1; j < length; j++) {
            if (activities[j].start >= activities[i].finish) {
                System.out.println("Start: " + activities[j].start + ", finish: " + activities[j].finish);
                i = j;
            }
        }
    }

    private static Activity[] sort(Activity[] activities, int length) {
        Activity t;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - (i + 1); j++) {
                if (activities[j].finish > activities[j + 1].finish) {
                    t = activities[j];
                    activities[j] = activities[j + 1];
                    activities[j + 1] = t;
                }
            }
        }
        return activities;
    }

    private static class Activity {
        int start, finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}

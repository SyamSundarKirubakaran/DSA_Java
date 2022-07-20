package problems.greedy;

import java.util.Arrays;

/**
 * @author SYAM K
 * @problem : Min no.of platforms required to station all trains without collision
 */
public class Three {

    private static final Train[] arr = new Train[]{
            new Train(1000, 1020),
            new Train(1015, 1400),
            new Train(1030, 1500),
            new Train(1040, 1055),
    };

    public static void main(String[] args) {
        

        findMinPlatform(arr, arr.length);

        
    }

    private static void findMinPlatform(Train[] arr, int length) {
        int platNeeded;
        System.out.println(Arrays.toString(arr));
        int result = 1;
        for (int i = 0; i < length; i++) {
            // minimum platform
            platNeeded = 1;

            for (int j = i + 1; j < length; j++) {
                // check for overlap
                if ((arr[i].arrival >= arr[j].arrival &&
                        arr[i].arrival <= arr[j].departure)
                        ||
                        (arr[j].arrival >= arr[i].arrival &&
                                arr[j].arrival <= arr[i].departure))
                    platNeeded++;
            }

            // update result
            result = Math.max(result, platNeeded);
        }
        System.out.println(result);
    }

    private static class Train {
        int arrival, departure;

        Train(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }

        @Override
        public String toString() {
            return "Train{" +
                    "arrival=" + arrival +
                    ", departure=" + departure +
                    '}';
        }
    }

}

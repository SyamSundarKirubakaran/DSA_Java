package problems.strings;

/**
 * @author SYAM K
 * @problem : Min and Max of an array using min no.of comparisons
 */
public class Sixteen {

    private static final int[] arr = {1000, 11, 445, 1, 330, 3000};
    private static final int arrSize = 6;

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(getMinMax(arr, arrSize));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }


    static Pair getMinMax(int[] arr, int n) {
        Pair minmax = new Pair();
        int i;
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        } else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
        }

        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            i += 2;
        }

        return minmax;
    }

    static class Pair {

        int min;
        int max;

        @Override
        public String toString() {
            return "Pair{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

}

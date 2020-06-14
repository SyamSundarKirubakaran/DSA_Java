package problems.strings;

/**
 * @author SYAM K
 * @problem : Min no.of palindromic sub-sequences to be removed to empty a binary string - Tournament Method
 */
public class Twenty {

    private static final int[] arr = {1000, 11, 445, 1, 330, 3000};
    private static final int arrSize = 6;

    public static void main(String[] args) {
        Long start = System.nanoTime();

        System.out.println(getMinMax(arr, 0, arrSize - 1));

        Long end = System.nanoTime();
        System.out.println("Runtime:" + (end - start) / 1.0e9 + " seconds");
    }

    static Pair getMinMax(int[] arr, int low, int high) {
        Pair minmax = new Pair();
        Pair mml, mmr;
        int mid;

        if (low == high) {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }

        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                minmax.max = arr[low];
                minmax.min = arr[high];
            } else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }

        mid = (low + high) / 2;
        mml = getMinMax(arr, low, mid);
        mmr = getMinMax(arr, mid + 1, high);

        minmax.min = Math.min(mml.min, mmr.min);

        minmax.max = Math.max(mml.max, mmr.max);

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

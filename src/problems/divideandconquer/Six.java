package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Missing number in arithmetic progression
 */
public class Six {

    private static final int[] arr = new int[]{-2, 0, 2, 6, 8, 10, 12, 14, 16, 18, 20};

    public static void main(String[] args) {
        

        int difference = (arr[arr.length - 1] - arr[0]) / arr.length;
        System.out.println(findMissingElement(arr, 0, arr.length - 1, difference));

        
    }

    private static int findMissingElement(int[] arr, int start, int end, int difference) {
        if (end <= start) {
            return Integer.MAX_VALUE;
        }
        int middle = start + (end - start) / 2;
        if (arr[middle + 1] - arr[middle] != difference) {
            return arr[middle] + difference;
        }
        if (middle > 0 && arr[middle] - arr[middle - 1] != difference) {
            return arr[middle - 1] + difference;
        }
        if (arr[middle] == arr[0] + middle * difference) {
            return findMissingElement(arr, middle + 1, end, difference);
        }
        return findMissingElement(arr, start, middle - 1, difference);
    }

}

package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Find the element that occurs more than n/2 times - Sorted Array.
 */
public class One {

    private static final int[] arr = new int[]{1, 2, 3, 4, 4, 4};

    public static void main(String[] args) {
        

        System.out.println(isMajority(arr, arr.length, 4));

        
    }

    private static boolean isMajority(int[] arr, int size, int checkElement) {
        int lastIndex = (size % 2 == 0) ? (size / 2 - 1) : (size / 2);
        for (int index = 0; index <= lastIndex; index++) {
            if (arr[index] == checkElement && arr[index + size / 2] == checkElement) {
                return true;
            }
        }
        return false;
    }

}

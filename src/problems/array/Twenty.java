package problems.array;

/**
 * @author SYAM K
 * @problem : Sub Array Sum equal to x
 */
public class Twenty {
    static int[] arr = new int[]{8, 6, 5, -2, 3, 4};

    public static void main(String[] args) {
        subArraySum(arr, arr.length - 1, 10);
    }

    private static void subArraySum(int[] arr, int size, int sum) {
        int currentSum = arr[0], start = 0;
        for (int i = 0; i <= size; i++) {
            while (currentSum > sum && start < i) {
                currentSum -= arr[start];
                start++;
            }
            if (currentSum == sum) {
                System.out.println("Sum from " + start + " to " + i);
                return;
            }
            if (i != size) { // can't consider last element because `i+1` is there in the body
                currentSum += arr[i + 1];
            }
        }
        System.out.println("!Found");
    }
}

package problems.array;

/**
 * @author SYAM K
 * @problem : Element that occurs more than n/2 times - Sorted
 */

class E {
    static int[] arr = new int[]{1, 1, 1, 2, 2, 2, 2};

    public static void main(String[] args) {
        int result = findMajorityElement(arr, arr.length - 1);
        if (result != -1)
            System.out.println("The Majority Element: " + result);
        else
            System.out.println("No Majority Element");
    }

    static int findMajorityElement(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            if (arr[i] == arr[size / 2 + 1]) {
                return arr[i];
            }
        }
        return -1;
    }
}
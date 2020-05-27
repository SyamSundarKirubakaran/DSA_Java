package problems.array;

/**
 * @author SYAM K
 * @problem : Binary Search
 */

class Two {
    static int[] arr = new int[]{2, 3, 4, 10, 40};

    public static void main(String[] args) {
        performBinarySearch(10, 0, arr.length - 1);
    }

    static void performBinarySearch(int key, int startIndex, int endIndex) {
        int middleIndex;
        while (startIndex <= endIndex) {
            middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (key == arr[middleIndex]) {
                System.out.println("found");
                return;
            }
            if (key < arr[middleIndex]) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        System.out.println("not found");
    }
}
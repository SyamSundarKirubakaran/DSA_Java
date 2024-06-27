package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Count Inversions in an array
 */
public class E {

    private static final int[] arr = new int[]{7, 5, 1, 3, 4, 6};
    private static final int[] temp = new int[arr.length];

    public static void main(String[] args) {
        

        System.out.println(mergeSort(arr, temp, 0, arr.length - 1));

        
    }

    private static int merge(int[] arr, int[] temp, int left, int middle, int right) {
        int leftIndex, rightIndex, result, inversionCount = 0;
        leftIndex = left;
        rightIndex = middle;
        result = left;
        while ((leftIndex <= middle - 1) && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[result] = arr[leftIndex];
                result += 1;
                leftIndex += 1;
            } else {
                temp[result] = arr[rightIndex];
                result += 1;
                rightIndex += 1;
                inversionCount += (middle - leftIndex);
            }
        }
        while (leftIndex <= middle - 1) {
            temp[result] = arr[leftIndex];
            result += 1;
            leftIndex += 1;
        }
        while (rightIndex <= right) {
            temp[result] = arr[rightIndex];
            result += 1;
            rightIndex += 1;
        }
        for (leftIndex = left; leftIndex <= right; leftIndex++) {
            arr[leftIndex] = temp[leftIndex];
        }
        return inversionCount;
    }

    private static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int middle, inversionCount = 0;
        if (left < right) {
            middle = (left + right) / 2;
            inversionCount = mergeSort(arr, temp, left, middle);
            inversionCount += mergeSort(arr, temp, middle + 1, right);
            inversionCount += merge(arr, temp, left, middle + 1, right);
        }
        return inversionCount;
    }

}

package problems.divideandconquer;

/**
 * @author SYAM K
 * @problem : Find median of 2 sorted arrays
 */
public class M {

    private static final int[] arr1 = new int[]{1, 12, 15, 26, 38};
    private static final int[] arr2 = new int[]{2, 13, 17, 30, 45};

    public static void main(String[] args) {


        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 != n2) {
            System.out.println("Unequal array length");
        } else if (n1 == 0) {
            System.out.println("empty array");
        } else if (n1 == 1) {
            System.out.println((arr1[0] + arr2[0]) / 2); // size is one
        } else {
            System.out.println(
                    getMedian(arr1, arr2, 0, 0, n1 - 1, n2 - 1)
            );
        }

        
    }

    private static int findMedian(int[] arr, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (arr[start + (n / 2)] + arr[start + (n / 2 - 1)]) / 2;
        } else {
            return arr[start + n / 2];
        }
    }

    private static int getMedian(int[] a, int[] b,
                                 int startA, int startB,
                                 int endA, int endB) {
        if (endA - startA == 1) { // size is 2
            return (
                    Math.max(a[startA], b[startB]) +
                            Math.min(a[endA], b[endB])
            ) / 2;
        }
        int m1 = findMedian(a, startA, endA);
        int m2 = findMedian(b, startB, endB);

        if (m1 == m2) {
            return m1;
        } else if (m1 < m2) {
            return getMedian(
                    a, b,
                    (endA + startA + 1) / 2,
                    startB, endA,
                    (endB + startB + 1) / 2
            );
        } else {
            return getMedian(
                    a, b, startA,
                    (endB + startB + 1) / 2,
                    (endA + startA + 1) / 2,
                    endB
            );
        }
    }

}

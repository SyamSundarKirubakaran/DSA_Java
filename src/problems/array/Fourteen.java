package problems.array;

/**
 * @author SYAM K
 * @problem : Find the Equilibrium Index .i.e., left sum and right sum of index should be equal.
 */

class Fourteen {
    static int[] arr = new int[]{10, 5, 15, 3, 4, 21, 2};

    public static void main(String[] args) {
        findEquilibiriumIndex(arr, arr.length - 1);
    }

    static void findEquilibiriumIndex(int[] arr, int size) {
        int[] sumFromLeft = new int[size + 1];
        int[] sumFromRight = new int[size + 1];
        sumFromLeft[0] = arr[0];
        sumFromRight[size] = arr[size];
        for (int i = 1; i <= size; i++) {
            sumFromLeft[i] = sumFromLeft[i - 1] + arr[i];
        }
        for (int i = size - 1; i >= 0; i--) {
            sumFromRight[i] = sumFromRight[i + 1] + arr[i];
        }
        for (int i = 0; i < size; i++) {
            if (sumFromLeft[i] == sumFromRight[i + 1]) {
                System.out.println("Eqilibirium Index: " + i);
                break;
            }
        }
    }

}
package problems.array;

/**
 * @author SYAM K
 * @problem : Linear Search
 */

class A {
    static int[] arr = new int[]{22, 33, 11, 55, 99, 77, 66, 88};

    public static void main(String[] args) {
        performLinearSearch(33);
    }

    static void performLinearSearch(int key) {
        for (int value : arr) {
            if (value == key) {
                System.out.println("found");
                return;
            }
        }
        System.out.println("!found");
    }

}
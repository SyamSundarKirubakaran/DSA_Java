package algo.sort;

class BubbleSortOne {

    static int[] arr = new int[]{22, 33, 11, 55, 99, 77, 66, 88};

    public static void main(String[] args) {
        performBubbleSort(arr.length - 1);
        printArray();
    }

    static void performBubbleSort(int size) {
        boolean isSwapped;
        for (int i = 0; i <= size; i++) {
            isSwapped = false;
            for (int j = 0; j <= size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
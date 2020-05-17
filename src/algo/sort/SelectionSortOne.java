package algo.sort;

class SelectionSortOne {
    static int[] arr = new int[]{22, 33, 11, 55, 99, 77, 66, 88};

    public static void main(String[] args) {
        performSelectionSort(arr.length - 1);
        printArray();
    }

    static void performSelectionSort(int size) {
        int min;
        for (int i = 0; i <= size - 1; i++) {
            min = i;
            for (int j = i + 1; j <= size; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(i, min);
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
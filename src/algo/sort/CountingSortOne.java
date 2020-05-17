package algo.sort;

import java.util.HashMap;
import java.util.Map;

class CountingSort {
    static int[] arr = new int[]{1, 2, 2, 1, 3, 4, 3, 9, 2, 3, 1, 8};

    public static void main(String[] args) {
        performCountingSort();
    }

    static void performCountingSort() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int value : arr) {
            hashMap.merge(value, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> mapElement : hashMap.entrySet()) {
            Integer count = mapElement.getValue();
            for (int i = 1; i <= count; i++)
                System.out.print(mapElement.getKey() + " ");
        }
    }

}
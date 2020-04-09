package algo.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SYAM K
 */
public class CountingSort {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 2, 2, 1, 4, 5, 4, 5, 1, 10, 9, 7);
        // Useful only if the range is known before hand and if the range is short and lot of repetitions
        performCountingSort(integerList);
    }

    private static void performCountingSort(List<Integer> integerList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer count;
        for (int i : integerList) {
            count = map.get(i);
            if (count == null)
                count = 0;
            count += 1;
            map.put(i, count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int decCount = entry.getValue();
            while (decCount > 0) {
                System.out.print(entry.getKey() + " ");
                decCount -= 1;
            }
        }
    }
}

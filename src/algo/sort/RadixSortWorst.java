package algo.sort;

import javafx.util.Pair;

import java.util.*;

/**
 * @author SYAM K
 */
public class RadixSortWorst {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(804, 21, 5, 64, 52, 1);
        int maxLength = findMaxLength(integerList);
        if (maxLength > 0) {
            performRadixSort(integerList, maxLength);
        } else {
            System.out.println("Error occurred");
        }
    }

    private static int findMaxLength(List<Integer> integerList) {
        int max = 0, count;
        for (int i : integerList) {
            count = 0;
            while (i != 0) {
                i /= 10;
                count += 1;
            }
            if (count > max) max = count;
        }
        return max;
    }

    // This is probably the worst code I've ever written - forgive me space and time complexity
    private static void performRadixSort(List<Integer> integerList, int maxLength) {
        List<Pair<Integer, List<Integer>>> pairList = new LinkedList<>();
        for (int i : integerList) {
            // change format based on max length of elements in the list
            String paddedNumber = String.format("%0" + maxLength + "d", i);
            List<Integer> digitList = new ArrayList<>();
            for (int j = 0; j < maxLength; j++) {
                digitList.add(Character.getNumericValue(paddedNumber.charAt(j)));
            }
            Pair<Integer, List<Integer>> pair = new Pair<>(i, digitList);
            pairList.add(pair);
        }
        LinkedHashMap<Integer, ArrayList<Pair<Integer, Integer>>> map = new LinkedHashMap<>();
        for (int z = 0; z < maxLength; z++) {
            ArrayList<Pair<Integer, Integer>> tempPairList = new ArrayList<>();
            for (int j = 0; j < pairList.size(); j++) {
                List<Integer> intList = pairList.get(j).getValue();
                Pair<Integer, Integer> innerPair = new Pair<>(pairList.get(j).getKey(), intList.get(z));
                tempPairList.add(innerPair);
            }
            map.put(z, tempPairList);
        }
        ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
        for (int i = keys.size() - 1; i >= 0; i--) {
            System.out.println(map.get(keys.get(i)));
            ArrayList<Pair<Integer, Integer>> temp = map.get(keys.get(i));
        }
    }
}

package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeSort {
    static List<Integer> unsortedList = Arrays.asList(9, 6, 5, 0, 8, 2, 7, 1, 100, 99, 67);

    public static void main(String[] args) {
        performMergeSort(0, unsortedList.size() - 1);
        printList(unsortedList);
    }

    static void performMerging(int startIndex, int middleIndex, int endIndex) {
        // left and right index array size `+1` because a MAX value has to be stored at the end
        int leftListSize = middleIndex - startIndex + 1;
        int rightListSize = endIndex - (middleIndex + 1) + 1;
        List<Integer> leftList = new ArrayList<>(leftListSize);
        List<Integer> rightList = new ArrayList<>(rightListSize);
        for (int i = startIndex; i <= middleIndex; i++) {
            leftList.add(unsortedList.get(i));
        }
        leftList.add(Integer.MAX_VALUE);
        for (int i = middleIndex + 1; i <= endIndex; i++) {
            rightList.add(unsortedList.get(i));
        }
        rightList.add(Integer.MAX_VALUE);
        int leftPointer = 0, rightPointer = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (leftList.get(leftPointer) < rightList.get(rightPointer)) {
                unsortedList.set(i, leftList.get(leftPointer));
                leftPointer += 1;
            } else {
                unsortedList.set(i, rightList.get(rightPointer));
                rightPointer += 1;
            }
        }
    }

    static void performMergeSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            performMergeSort(startIndex, middleIndex);
            performMergeSort(middleIndex + 1, endIndex);
            performMerging(startIndex, middleIndex, endIndex);
        }
    }

    static void printList(List<Integer> sortedList) {
        for (Integer integer : sortedList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
package algo.sort;

import java.util.Arrays;
import java.util.List;

class InsertionSort {
	public static void main(String[] args) {
		List<Integer> unsortedList = Arrays.asList(9, 6, 5, 0, 8, 2, 7, 1);
		printList(performInsertionSort(unsortedList));
	}

	static List<Integer> performInsertionSort(List<Integer> unsortedList) {
		int startIndex = 1, endIndex = unsortedList.size() - 1;
		int key, j;
		for (int i = startIndex; i <= endIndex; i++) {
			key = unsortedList.get(i);
			j = i - 1;
			while (j >= 0 && unsortedList.get(j) > key) {
				unsortedList.set(j + 1, unsortedList.get(j));
				j -= 1;
			}
			unsortedList.set(j + 1, key);
		}
		return unsortedList;
	}

	static void printList(List<Integer> intList) {
		for (Integer integer : intList) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
}


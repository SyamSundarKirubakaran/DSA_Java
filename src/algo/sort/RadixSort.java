package algo.sort;

class RadixSort {

	// Here the stable sorting algorithm used inside radix sort is merge sort,
	// use counting sort for better complexity.

	public static void main(String[] args) {
		int[] arr = new int[]{170, 45, 75, 90, 802, 24, 2, 66, 1023};
		performRadixSort(arr);
	}

	static void performRadixSort(int[] arr) {
		int maxDigits = findMaxDigits(arr);
		int[] digitsArray = new int[arr.length];
		System.arraycopy(arr, 0, digitsArray, 0, arr.length);
		for (int i = 1; i <= maxDigits; i++) {
			for (int j = 0; j < arr.length; j++) {
				digitsArray[j] = digitsArray[j] % 10;
			}
			performMergeSort(digitsArray, arr, 0, digitsArray.length - 1);
			for (int j = 0; j < arr.length; j++) {
				digitsArray[j] = arr[j] / (int) Math.pow(10, i);
			}
			System.out.print("Step - " + i + ": ");
			printArray(arr);
		}
	}

	static int findMaxDigits(int[] arr) {
		int max = 0, count;
		for (int value : arr) {
			count = 0;
			while (value != 0) {
				count += 1;
				value /= 10;
			}
			if (count > max)
				max = count;
		}
		return max;
	}

	static void performMergeSort(int[] arr, int[] wholeNumberArr, int startIndex, int endIndex) {
		int middleIndex;
		if (startIndex < endIndex) {
			middleIndex = (startIndex + endIndex) / 2;
			performMergeSort(arr, wholeNumberArr, startIndex, middleIndex);
			performMergeSort(arr, wholeNumberArr, middleIndex + 1, endIndex);
			performMerging(arr, wholeNumberArr, startIndex, middleIndex, endIndex);
		}
	}

	static void performMerging(int[] arr, int[] wholeNumberArr, int startIndex, int middleIndex, int endIndex) {
		int leftArraySize = middleIndex - startIndex + 2;
		int rightArraySize = endIndex - (middleIndex + 1) + 2;

		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		// Size will remain the same for both digits and wholeNumber array.
		int[] leftWholeArray = new int[leftArraySize];
		int[] rightWholeArray = new int[rightArraySize];

		int j = 0;
		for (int i = startIndex; i <= middleIndex; i++) {
			leftArray[j] = arr[i];
			leftWholeArray[j] = wholeNumberArr[i];
			j++;
		}
		leftArray[leftArraySize - 1] = Integer.MAX_VALUE;
		leftWholeArray[leftArraySize - 1] = Integer.MAX_VALUE;

		j = 0;
		for (int i = middleIndex + 1; i <= endIndex; i++) {
			rightArray[j] = arr[i];
			rightWholeArray[j] = wholeNumberArr[i];
			j++;
		}
		rightArray[rightArraySize - 1] = Integer.MAX_VALUE;
		rightWholeArray[rightArraySize - 1] = Integer.MAX_VALUE;


		int leftIndex = 0, rightIndex = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				arr[i] = leftArray[leftIndex];
				wholeNumberArr[i] = leftWholeArray[leftIndex];
				leftIndex += 1;
			} else {
				arr[i] = rightArray[rightIndex];
				wholeNumberArr[i] = rightWholeArray[rightIndex];
				rightIndex += 1;
			}
		}
	}

	static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}



package algo.sort

/**
 * @author SYAM K
 */

fun main() {
    val integerList = mutableListOf(22, 33, 11, 55, 99, 77, 66, 88)
    performQuickSort(integerList = integerList, startIndex = 0, endIndex = integerList.size - 1)
    println(integerList)
}

fun performQuickSort(integerList: MutableList<Int>, startIndex: Int, endIndex: Int) {
    if (startIndex < endIndex) {
        val partitionIndex = performPartition(integerList, startIndex, endIndex)
        performQuickSort(integerList = integerList, startIndex = startIndex, endIndex = partitionIndex - 1)
        performQuickSort(integerList = integerList, startIndex = partitionIndex + 1, endIndex = endIndex)
    }
}

fun performPartition(integerList: MutableList<Int>, startIndex: Int, endIndex: Int): Int {
    val pivot = integerList[endIndex]
    var i = startIndex - 1
    for (j in startIndex until endIndex) {
        if (integerList[j] <= pivot) {
            i += 1
            swap(integerList = integerList, i = i, j = j)
        }
    }
    swap(integerList = integerList, i = i + 1, j = endIndex)
    return i + 1
}

fun swap(integerList: MutableList<Int>, i: Int, j: Int) {
    if (i != j && integerList[i] != integerList[j]) {
        integerList[i] = integerList[i] + integerList[j]
        integerList[j] = integerList[i] - integerList[j]
        integerList[i] = integerList[i] - integerList[j]
    }
}

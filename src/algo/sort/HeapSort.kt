package algo.sort

/**
 * @author SYAM K
 */
fun main() {
    val integerList = mutableListOf(22, 33, 11, 55, 99, 77, 66, 88)
    performHeapSort(integerList)
    println(integerList)
}

private fun performHeapSort(integerList: MutableList<Int>) {
    var heapSize = integerList.size - 1
    constructHeap(integerList = integerList, heapSize = heapSize)
    for (i in (integerList.size - 1) downTo 0) {
        performSwap(integerList = integerList, i = 0, j = i)
        heapSize -= 1
        maxHeapify(integerList = integerList, parent = 0, heapSize = heapSize)
    }
}

private fun constructHeap(integerList: MutableList<Int>, heapSize: Int) {
    for (i in (integerList.size - 1) / 2 downTo 0)
        maxHeapify(integerList = integerList, parent = i, heapSize = heapSize)
}

private fun maxHeapify(integerList: MutableList<Int>, parent: Int, heapSize: Int) {
    val leftChild = parent * 2
    val rightChild = leftChild + 1
    var largest = parent
    if (leftChild <= heapSize && integerList[leftChild] > integerList[largest])
        largest = leftChild
    if (rightChild <= heapSize && integerList[rightChild] > integerList[largest])
        largest = rightChild
    if (largest != parent) {
        performSwap(integerList = integerList, i = largest, j = parent)
        maxHeapify(integerList = integerList, parent = largest, heapSize = heapSize)
    }
}

private fun performSwap(integerList: MutableList<Int>, i: Int, j: Int) {
    if (i != j && integerList[i] != integerList[j]) {
        integerList[i] = integerList[i] + integerList[j]
        integerList[j] = integerList[i] - integerList[j]
        integerList[i] = integerList[i] - integerList[j]
    }
}

package algo.sort

/**
 * @author SYAM K
 */

fun main() {
    val integerList = mutableListOf(22, 33, 11, 55, 99, 77, 66, 88)
    performMergeSort(integerList = integerList, startIndex = 0, endIndex = integerList.size - 1)
    println(integerList)
}

private fun performMergeSort(integerList: MutableList<Int>, startIndex: Int, endIndex: Int) {
    if (startIndex < endIndex) {
        val middleIndex = (startIndex + endIndex) / 2
        performMergeSort(integerList = integerList, startIndex = startIndex, endIndex = middleIndex)
        performMergeSort(integerList = integerList, startIndex = middleIndex + 1, endIndex = endIndex)
        performMerge(integerList = integerList, startIndex = startIndex, middleIndex = middleIndex, endIndex = endIndex)
    }
}

private fun performMerge(integerList: MutableList<Int>, startIndex: Int, middleIndex: Int, endIndex: Int) {
    val leftListSize = middleIndex - startIndex + 1
    val rightListSize = endIndex - middleIndex
    val leftList: MutableList<Int> = mutableListOf()
    val rightList: MutableList<Int> = mutableListOf()
    for (i in 0 until leftListSize)
        leftList.add(i, integerList[startIndex + i])
    for (j in 0 until rightListSize)
        rightList.add(j, integerList[(middleIndex + 1) + j])
    leftList.add(Int.MAX_VALUE)
    rightList.add(Int.MAX_VALUE)
    var i = 0
    var j = 0
    for (k in startIndex..endIndex) {
        if (leftList[i] <= rightList[j]) {
            integerList[k] = leftList[i]
            i += 1
        } else {
            integerList[k] = rightList[j]
            j += 1
        }
    }
}

package algo.sort

/**
 * @author SYAM K
 */
fun main() {
    val integerList = mutableListOf(22, 33, 11, 55, 99, 77, 66, 88)
    performBubbleSort(integerList)
    println(integerList)
}

fun performBubbleSort(integerList: MutableList<Int>) {
    var swapPerformed: Boolean
    for (i in 0 until integerList.size) {
        swapPerformed = false
        for (j in 0 until integerList.size - i - 1) {
            if (integerList[j] > integerList[j + 1]) {
                swap(integerList = integerList, i = j, j = j + 1)
                swapPerformed = true
            }
        }
        if (!swapPerformed) break
    }
}

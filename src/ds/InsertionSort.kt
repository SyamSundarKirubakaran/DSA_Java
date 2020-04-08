package ds

/**
 * @author SYAM K
 */

fun main() {
    println(performInsertionSort(mutableListOf(22, 33, 11, 55, 99, 77, 66, 88)))
}

fun performInsertionSort(integerList: MutableList<Int>): List<Int> {
    var i: Int
    var currentValue: Int
    for (j in 1 until integerList.size) {
        currentValue = integerList[j]
        i = j - 1
        while (i >= 0 && integerList[i] > currentValue) {
            integerList[i + 1] = integerList[i]
            i -= 1
        }
        integerList[i + 1] = currentValue
    }
    return integerList
}

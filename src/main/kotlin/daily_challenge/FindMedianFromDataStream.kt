package daily_challenge

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/find-median-from-data-stream/
 */

fun main() {
    val median = FindMedianFromDataStream()
    median.addNum(1)
    median.addNum(2)
    println(median.findMedian())
    median.addNum(3)
    println(median.findMedian())
}

class FindMedianFromDataStream {

    private val list = mutableListOf<Int>()

    fun addNum(num: Int) {
        val index = list.binarySearch(num)
        val insertIndex = if (index < 0) {
            -index - 1
        } else {
            index
        }
        list.add(insertIndex, num)
    }

    fun findMedian(): Double {
        if (list.isEmpty()) return 0.0
        val mid = list.lastIndex / 2

        return if (list.size % 2 == 0) {
            (list[mid] + list[mid + 1]).toDouble() / 2
        } else {
            list[mid].toDouble()
        }

    }
}
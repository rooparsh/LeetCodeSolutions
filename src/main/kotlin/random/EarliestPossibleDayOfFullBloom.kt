package random

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
 */

fun main() {
    print(EarliestPossibleDayOfFullBloom().earliestFullBloom(intArrayOf(1, 4, 3), intArrayOf(2, 3, 1)))
}

class EarliestPossibleDayOfFullBloom {
    fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
        val indexes = Array(plantTime.size) { it }
        indexes.sortWith(Comparator { a,b -> growTime[b] - growTime[a] } )

        var dayPlant = 0
        var dayGrow = 0

        indexes.forEach { index ->
            dayPlant += plantTime[index]
            dayGrow = Math.max(dayGrow, dayPlant + growTime[index])
        }

        return dayGrow
    }
}
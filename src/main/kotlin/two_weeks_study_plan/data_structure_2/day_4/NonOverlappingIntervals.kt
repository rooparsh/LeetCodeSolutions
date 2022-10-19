package two_weeks_study_plan.data_structure_2.day_4

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/non-overlapping-intervals/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    val array = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 2),
        intArrayOf(1, 2)
    )
    print(NonOverlappingIntervals().eraseOverlapIntervals(array))
}

class NonOverlappingIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        intervals.sortWith(compareBy({ it.first() }, { it.last() }))
        var count = 0
        var temp = intervals.first().last()
        for (i in 1..intervals.lastIndex) {
            temp = if (intervals[i].first() >= temp) {
                intervals[i].last()
            } else {
                count++
                minOf(intervals[i].last(), temp)
            }
        }
        return count
    }
}
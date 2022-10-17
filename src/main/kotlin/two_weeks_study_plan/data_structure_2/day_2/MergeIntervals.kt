package two_weeks_study_plan.data_structure_2.day_2

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/merge-intervals/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(
        MergeIntervals().merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        ).joinToString()
    )
}

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()

        intervals.forEach {
            if (result.isEmpty() || result.last()[1] < it[0]) {
                result.add(it)
            } else {
                result.last()[1] = maxOf(result.last()[1], it[1])
            }
        }

        return result.toTypedArray()
    }
}
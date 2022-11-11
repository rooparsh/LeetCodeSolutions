package two_weeks_study_plan.data_structure.data_structure_1.day_1

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/maximum-subarray/?envType=study-plan&id=data-structure-i
 */

fun main() {

    val array = arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).toIntArray()

    val maximumSubarray = MaximumSubarray()
    println(maximumSubarray.maxSubArray(array))
}

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var current = 0
        nums.forEach {
            current = maxOf(current + it, it)
            max = maxOf(current, max)
        }
        return max
    }
}
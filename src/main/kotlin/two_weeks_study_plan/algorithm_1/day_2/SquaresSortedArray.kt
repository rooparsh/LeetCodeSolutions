package two_weeks_study_plan.algorithm_1.day_2

import kotlin.math.absoluteValue


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/squares-of-a-sorted-array/?envType=study-plan&id=algorithm-i
 */

fun main() {

    val array = arrayOf(-4, -1, 0, 3, 10).toIntArray()
    print(SquaresSortedArray().sortedSquares(array).joinToString())

}

class SquaresSortedArray {

    fun sortedSquaresEasy(nums: IntArray): IntArray {
        return nums.map { it * it }.sorted().toIntArray()
    }

    fun sortedSquares(nums: IntArray): IntArray {
        val array = IntArray(nums.size)

        var start = 0
        var end = nums.size - 1
        for (i in nums.size - 1 downTo 0) {
            if (nums[start].absoluteValue > nums[end].absoluteValue) {
                array[i] = nums[start] * nums[start]
                start++
            } else {
                array[i] = nums[end] * nums[end]
                end--
            }
        }

        return array
    }
}
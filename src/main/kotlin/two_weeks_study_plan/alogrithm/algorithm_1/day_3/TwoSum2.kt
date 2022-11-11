package two_weeks_study_plan.alogrithm.algorithm_1.day_3

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan&id=algorithm-i
 */

fun main() {
    val array = arrayOf(2, 7, 11, 15).toIntArray()
    println(TwoSum2().twoSum(array, 9).joinToString())
}

class TwoSum2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var startIdx = 0
        var endIdx = numbers.size - 1

        while (startIdx <= endIdx) {
            val sum = numbers[startIdx] + numbers[endIdx]
            if (sum == target) {
                return intArrayOf(startIdx + 1, endIdx + 1)
            } else if (sum < target) {
                startIdx++
                continue
            } else {
                endIdx--
                continue
            }
        }

        return intArrayOf(0, 0)
    }
}
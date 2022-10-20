package two_weeks_study_plan.data_structure_2.day_5

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/subarray-sum-equals-k/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(SubArraySum().subarraySum(intArrayOf(1,1,1), 2))
}

class SubArraySum {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSum = hashMapOf<Int, Int>()

        var sum = 0
        var counter = 0
        nums.forEach { num ->
            sum += num
            if (sum == k) ++counter
            prefixSum[sum - k]?.let { counter += it }
            prefixSum[sum] = (prefixSum[sum] ?: 0) + 1
        }

        return counter
    }
}
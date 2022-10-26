package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/continuous-subarray-sum/
 */

fun main() {
    print(ContinuousSubArraySum().checkSubarraySum(intArrayOf(23, 2, 4, 6, 7), 6))
}

class ContinuousSubArraySum {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val sumToIdx = hashMapOf(0 to -1)

        var sum = 0

        nums.forEachIndexed { index, num ->
            sum += num

            if (k != 0)
                sum %= k

            if (index - sumToIdx.getOrPut(sum) { index } > 1)
                return true
        }

        return false
    }
}
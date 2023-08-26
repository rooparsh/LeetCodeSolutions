package leetcode_75.daily.two_pointer

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(maxOperations(intArrayOf(4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4), 2))
}

fun maxOperations(nums: IntArray, k: Int): Int {
    nums.sort()
    var result = 0

    var left = 0
    var right = nums.lastIndex

    while (left < right) {
        val sum = nums[left] + nums[right]

        when {
            (sum == k) -> {
                result++
                left++
                right--
            }

            sum < k -> left++
            else -> right--
        }

    }
    return result
}
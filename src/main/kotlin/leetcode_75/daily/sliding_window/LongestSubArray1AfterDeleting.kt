package leetcode_75.daily.sliding_window

import kotlin.math.max

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(longestSubarray(intArrayOf(1, 1, 0, 1)))
}

fun longestSubarray(nums: IntArray): Int {
    var answer = 0
    var countZeros = 0
    var left = 0

    for (right in nums.indices) {
        countZeros += if (nums[right] == 0) {
            1
        } else {
            0
        }

        while (countZeros > 1) {
            countZeros -= if (nums[left] == 0) {
                1
            } else {
                0
            }
            left++
        }

        answer = max(answer, right - left)
    }
    return answer
}
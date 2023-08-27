package leetcode_75.daily.sliding_window

import kotlin.math.max

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
 */
fun main() {
    println(longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2))
}

fun longestOnes(nums: IntArray, k: Int): Int {
    if (nums.size < k) return 0

    var answer = 0
    var curr = 0
    var left = 0

    for (right in nums.indices) {
        if (nums[right] == 0) curr++
        while (curr > k) {
            if (nums[left] == 0) curr--
            left++
        }

        answer = max(answer, right - left + 1)
    }

    return answer
}
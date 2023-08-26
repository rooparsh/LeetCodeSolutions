package leetcode_75.daily.sliding_window

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/maximum-average-subarray-i/
 */

fun main() {
    println(findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var (sum, max) = 0 to Int.MIN_VALUE
    nums.forEachIndexed { i, v ->
        sum += v
        if (i >= k - 1) {
            max = max.coerceAtLeast(sum)
            sum -= nums[i - k + 1]
        }
    }
    return max / k.toDouble()
}
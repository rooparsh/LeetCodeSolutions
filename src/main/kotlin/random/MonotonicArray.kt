package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/monotonic-array/
 */

fun main() {

    val array1 = arrayOf(1, 2, 3, 0, 4).toIntArray()
    print(MonotonicArray().isMonotonic(array1))

}

class MonotonicArray {
    fun isMonotonic(nums: IntArray): Boolean {
        var isIncreasing = true
        var isDecreasing = true

        for (i in 0 until nums.size - 1) {
            if (nums[i] > nums[i + 1]) {
                isIncreasing = false
            } else if (nums[i] < nums[i + 1]) {
                isDecreasing = false
            }
        }

        return isIncreasing or isDecreasing
    }
}
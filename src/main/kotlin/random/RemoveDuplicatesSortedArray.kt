package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

fun main() {
    println(RemoveDuplicatesSortedArray().removeDuplicates2(intArrayOf(1, 1, 2)))
}

class RemoveDuplicatesSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 2) return nums.size

        var i = 0
        for (j in 1 until nums.size) {
            if (nums[j] != nums[j - 1]) {
                nums[++i] = nums[j]
            }
        }
        return i + 1
    }

    fun removeDuplicates2(nums: IntArray): Int {
        var length = 0
        if (nums.isEmpty()) return length

        nums.forEach {
            if (nums[length] != it) {
                nums[++length] = it
            }
        }

        return length + 1
    }
}
package leetcode_75.daily.two_pointer

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}

fun moveZeroes(nums: IntArray) {
    var pointer = 0
    nums.forEach {
        if (it != 0) {
            nums[pointer++] = it
        }
    }
    while (pointer < nums.size) {
        nums[pointer++] = 0
    }

    println(nums.joinToString())
}

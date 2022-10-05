package two_weeks_study_plan.algorithm_1.day_3


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/move-zeroes/?envType=study-plan&id=algorithm-i
 */

fun main() {
    val array = arrayOf(0, 1, 0, 3, 12).toIntArray()
    MoveZeroes().moveZeroes(array)
    println(array.joinToString())
}

class MoveZeroes {
    fun moveZeroes(nums: IntArray) {
        for (i in nums.indices) {
            for (j in i until nums.size) {
                if (nums[i] == 0 && nums[j] != 0) {
                    nums[i] = nums[j].also { nums[j] = nums[i] }
                }
            }
        }
    }
}
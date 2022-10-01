package leetcode_75.level_1.day_1


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1
 */

fun main() {
    println(FindPivotIndex().pivotIndex(arrayOf(1, 7, 3, 6, 5, 6).toIntArray()))
}

class FindPivotIndex {

    fun pivotIndex(nums: IntArray): Int {
        var leftSum = 0
        val sum = nums.sum()

        for (i in nums.indices) {
            if (leftSum == sum - leftSum - nums[i]) return i
            leftSum += nums[i]
        }

        return -1
    }
}
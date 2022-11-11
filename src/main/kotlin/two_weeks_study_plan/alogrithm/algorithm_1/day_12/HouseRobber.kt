package two_weeks_study_plan.alogrithm.algorithm_1.day_12

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/house-robber/?envType=study-plan&id=algorithm-i
 */

fun main() {
    print(HouseRobber().rob(intArrayOf(1, 2, 3, 1)))
}

class HouseRobber {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])


        var prevDouble = nums[0]
        var prevOne = maxOf(nums[0], nums[1])
        var result = 0
        for (i in 2 until nums.size) {
            result = maxOf(prevOne, nums[i] + prevDouble)
            prevDouble = prevOne
            prevOne = maxOf(prevOne, result)
        }

        return result

    }
}
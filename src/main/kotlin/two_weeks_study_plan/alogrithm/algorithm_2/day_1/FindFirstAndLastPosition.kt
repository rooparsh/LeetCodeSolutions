package two_weeks_study_plan.alogrithm.algorithm_2.day_1

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan&id=algorithm-ii
 */
fun main() {
    print(FindFirstAndLastPosition().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).joinToString())
}

class FindFirstAndLastPosition {
    fun searchRange(nums: IntArray, target: Int, left: Int = 0, right: Int = nums.size): IntArray {
        val mid = left + (right - left) / 2

        return if (left == right) intArrayOf(-1, -1)
        else if (nums[mid] == target) {
            val lowerRange = searchRange(nums, target, left, mid)
            val upperRange = searchRange(nums, target, mid + 1, right)

            val first = if (lowerRange[0] != -1) lowerRange[0] else mid
            val last = if (upperRange[1] != -1) upperRange[1] else mid

            intArrayOf(first, last)

        } else if (nums[mid] < target) {
            searchRange(nums, target, mid + 1, right)
        } else {
            searchRange(nums, target, left, mid)
        }

    }
}
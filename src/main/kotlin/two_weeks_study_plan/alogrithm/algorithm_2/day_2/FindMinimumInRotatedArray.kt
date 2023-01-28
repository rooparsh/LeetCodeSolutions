package two_weeks_study_plan.alogrithm.algorithm_2.day_2


/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/?envType=study-plan&id=algorithm-ii
 */

fun main() {
    print(FindMinimumInRotatedArray().findMin(intArrayOf(3, 4, 5, 1, 2)))
}

class FindMinimumInRotatedArray {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        if (nums[0] <= nums[right]) {
            return nums[0]
        }
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1]
            if (nums[mid] < nums[mid - 1]) return nums[mid]
            if (nums[mid] > nums[0]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}
package two_weeks_study_plan.alogrithm.algorithm_2.day_1

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=study-plan&id=algorithm-ii
 */

fun main() {
    print(SearchInRotatedArray().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
}

class SearchInRotatedArray {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val m = l + (r - l) / 2

            if (nums[m] == target) return m

            if (nums[m] <= nums[r]) {
                if (target > nums[m] && target <= nums[r]) l = m + 1
                else r = m - 1
            } else {
                if (target < nums[m] && target >= nums[l]) r = m - 1
                else l = m + 1
            }
        }
        return -1
    }
}
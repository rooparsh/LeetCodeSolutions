package two_weeks_study_plan.alogrithm.algorithm_2.day_2

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/find-peak-element/solutions/?envType=study-plan&id=algorithm-ii
 */


fun main() {
    print(FindPeakElement().findPeakElement(intArrayOf(1, 2, 3, 1)))
}

class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        if (nums.size < 3) {
            return if (nums[0] > nums[1]) 0 else 1
        }
        for (i in nums.indices) {
            if (i == nums.size - 1) return i
            if (i > 0 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i
            if (i == 0 && nums[i] > nums[i + 1]) return i
        }

        return nums.size - 1
    }
}
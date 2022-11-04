package two_weeks_study_plan.data_structure_2.day_20

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    println(KthLargestElementInArray().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
}

class KthLargestElementInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return nums.sortedArrayDescending()[k - 1]
    }
}
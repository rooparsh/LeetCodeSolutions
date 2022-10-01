package two_weeks_study_plan.algorithm_1


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/search-insert-position/?envType=study-plan&id=algorithm-i
 */

fun main() {
    val array = arrayOf(1, 3, 5, 6).toIntArray()

    print(SearchInsertPosition().searchInsert(array, 7))
}


class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var startIndex = 0
        var endIndex = nums.size - 1

        while (startIndex <= endIndex) {
            val center = (startIndex + endIndex) / 2

            if (target == nums[center]) {
                return center
            } else if (target > nums[center]) {
                startIndex = center + 1
            } else if (target < nums[center]) {
                endIndex = center - 1
            }
        }
        return startIndex
    }
}
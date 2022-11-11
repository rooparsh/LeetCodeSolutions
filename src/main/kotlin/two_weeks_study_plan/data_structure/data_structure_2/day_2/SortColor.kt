package two_weeks_study_plan.data_structure.data_structure_2.day_2

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/sort-colors/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    val array = intArrayOf(2, 0, 2, 1, 1, 0)
    SortColor().sortColors(array)
    print(array.joinToString())
}

class SortColor {
    fun sortColors(nums: IntArray) {
        var startId = 0
        while (startId < nums.size - 1) {
            var smallestIdx = startId
            for (i in startId + 1 until nums.size) {
                if (nums[smallestIdx] > nums[i]) {
                    smallestIdx = i
                }
            }
            val temp = nums[startId]
            nums[startId] = nums[smallestIdx]
            nums[smallestIdx] = temp
            startId++

        }
    }
}
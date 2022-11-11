package two_weeks_study_plan.data_structure.data_structure_2.day_1

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/3sum/?envType=study-plan&id=data-structure-ii
 */
fun main() {
    print(ThreeSum().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        var start = -1
        val result = mutableListOf<List<Int>>()
        val numberToIndexesMap  = mutableMapOf<Int, SortedSet<Int>>()
        nums.forEachIndexed { index, element -> numberToIndexesMap[element] = numberToIndexesMap[element]?.apply { add(index) } ?: sortedSetOf(index) }

        while (start < nums.size - 2) {
            start++
            if (start > 0 && nums[start] == nums[start - 1]) continue
            var end = nums.size
            while (end > start) {
                end--
                if (end < nums.size - 1 && nums[end] == nums[end + 1]) continue
                numberToIndexesMap[-nums[start] - nums[end]]?.firstOrNull() { it in (start + 1) until end }?.apply {
                    result.add(listOf(nums[start], nums[this], nums[end]))
                }
            }
        }
        return result
    }
}
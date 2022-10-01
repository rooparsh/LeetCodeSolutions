package two_weeks_study_plan.data_structure_1

import kotlin.collections.HashMap

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/contains-duplicate/?envType=study-plan&id=data-structure-i
 */

fun main() {

    val intArray = IntArray(4)
    intArray[0] = 1
    intArray[1] = 2
    intArray[2] = 3
    intArray[3] = 1
    val solutions = Solution()
    println(solutions.containsDuplicate(intArray))
}

internal class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {

        val frequencyMap = HashMap<Int, Int>()

        nums.map { frequencyMap[it] = frequencyMap[it]?.plus(1) ?: 1 }

        return frequencyMap.filterValues { it > 1 }.isNotEmpty()
    }
}
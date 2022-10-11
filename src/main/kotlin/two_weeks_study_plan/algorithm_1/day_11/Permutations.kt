package two_weeks_study_plan.algorithm_1.day_11

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/permutations/?envType=study-plan&id=algorithm-i
 */

fun main() {
    print(Permutations().permute(intArrayOf(1, 2, 3)).joinToString())
}

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        var duplicate = nums

        for (i in nums.size - 1 downTo 0) {
            for (j in nums.size - 1 downTo 0) {
                if (i == j) {
                    continue
                }
                duplicate[i] = duplicate[j].also { duplicate[j] = duplicate[i] }
                result.add(duplicate.toList())
                duplicate = nums
            }
        }
        return result

    }

    fun permute(
        nums: IntArray,
        tempList: List<Int> = listOf(),
        numsList: List<Int> = nums.toList()
    ): List<List<Int>> = when (numsList.size) {
        1 -> listOf(tempList + numsList)
        else -> numsList.flatMap { num -> permute(nums, tempList + num, numsList - num) }
    }
}
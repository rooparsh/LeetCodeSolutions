package two_weeks_study_plan.alogrithm.algorithm_1.day_11


/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/combinations/?envType=study-plan&id=algorithm-i
 */

fun main() {
    print(Combinations().combine(4, 2).joinToString())
}

class Combinations {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(currentCombination: List<Int>, startIndex: Int) {
            if (currentCombination.size == k) {
                result += currentCombination
                return
            }
            for (i in startIndex..n) {
                if (currentCombination.contains(i)) {
                    continue
                }
                val newCombination = currentCombination.toMutableList()
                newCombination += i
                dfs(newCombination, i + 1)
            }
        }

        dfs(mutableListOf(), 1)
        return result
    }
}
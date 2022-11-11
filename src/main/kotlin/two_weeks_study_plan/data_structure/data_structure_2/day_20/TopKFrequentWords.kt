package two_weeks_study_plan.data_structure.data_structure_2.day_20

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/top-k-frequent-elements/?envType=study-plan&id=data-structure-ii
 */
fun main() {
    println(TopKFrequentWords().topKFrequent(intArrayOf(4, 1, -1, 2, -1, 2, 3), 2).joinToString())
}

class TopKFrequentWords {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()

        nums.forEach {
            frequencyMap[it] = frequencyMap[it]?.plus(1) ?: 1
        }

        return frequencyMap.toList().sortedByDescending { it.second }.map { it.first }.subList(0, k).toIntArray()
    }
}
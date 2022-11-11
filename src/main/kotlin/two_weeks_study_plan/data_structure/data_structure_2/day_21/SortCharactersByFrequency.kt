package two_weeks_study_plan.data_structure.data_structure_2.day_21

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/sort-characters-by-frequency/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(SortCharactersByFrequency().frequencySort("Aabb"))
}

class SortCharactersByFrequency {
    fun frequencySort(s: String): String {
        return s.toCharArray()
            .toList()
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedByDescending { it.second }
            .joinToString("") { pair ->
                val string = StringBuilder()
                repeat(pair.second) {
                    string.append(pair.first.toString())
                }
                return@joinToString string
            }
    }
}
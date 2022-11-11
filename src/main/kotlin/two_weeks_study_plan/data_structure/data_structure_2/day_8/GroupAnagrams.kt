package two_weeks_study_plan.data_structure.data_structure_2.day_8

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/group-anagrams/?envType=study-plan&id=data-structure-ii
 */
fun main() {
    print(GroupAnagrams().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).joinToString())
}

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { it.groupingBy { it }.eachCount() }.values.toList()
    }

    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val map = mutableMapOf<String, MutableList<String>>()

        strs.map {
            val sortedString = it.toCharArray().sorted().joinToString()

            val anagrams: MutableList<String> = map[sortedString] ?: mutableListOf()
            anagrams.add(it)
            map.put(sortedString, anagrams)
        }

        map.values.map { result.add(it) }
        return result
    }
}
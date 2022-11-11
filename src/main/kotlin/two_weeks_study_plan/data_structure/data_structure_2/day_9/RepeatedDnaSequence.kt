package two_weeks_study_plan.data_structure.data_structure_2.day_9

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/repeated-dna-sequences/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(RepeatedDnaSequence().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").joinToString())
}

class RepeatedDnaSequence {
    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length < 10) return listOf()
        val map = HashMap<String, Int>()

        for (i in s.indices) {
            if (i + 10 > s.length) break
            val sub = s.substring(i, i + 10)
            map[sub] = (map[sub] ?: 0) + 1
        }

        return map.filterValues { it > 1 }.keys.toList()
    }
}
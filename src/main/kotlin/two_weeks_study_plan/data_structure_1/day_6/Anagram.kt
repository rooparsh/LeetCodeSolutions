package two_weeks_study_plan.data_structure_1.day_6

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/valid-anagram/?envType=study-plan&id=data-structure-i
 */

fun main() {
    println(Anagram().isAnagram("anagram", "nagaram"))
}

class Anagram {
    fun isAnagram(s: String, t: String): Boolean {
        return s.toCharArray().apply { sort() }.contentEquals(t.toCharArray().apply { sort() })
    }
}
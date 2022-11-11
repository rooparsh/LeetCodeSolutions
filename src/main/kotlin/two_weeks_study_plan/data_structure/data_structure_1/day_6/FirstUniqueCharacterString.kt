package two_weeks_study_plan.data_structure.data_structure_1.day_6


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/first-unique-character-in-a-string/?envType=study-plan&id=data-structure-i
 */

fun main() {

    println(FirstUniqueCharacterString().firstUniqChar("loveleetcode"))

}

class FirstUniqueCharacterString {
    fun firstUniqChar(s: String): Int {

        if (s.isEmpty()) return -1

        val frequencyMap = s.groupingBy { it }.eachCount()

        s.forEachIndexed { index, c -> if (frequencyMap[c] == 1) return index }

        return -1
    }
}
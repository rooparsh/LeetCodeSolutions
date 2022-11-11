package two_weeks_study_plan.data_structure.data_structure_1.day_6

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/ransom-note/?envType=study-plan&id=data-structure-i
 */

fun main() {
    println(RansomNote().canConstruct("aa", "ab"))
}

class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineMap = magazine.groupingBy { it }.eachCount()
        val ransomMap = ransomNote.groupingBy { it }.eachCount()

        ransomMap.forEach { (key, value) ->
            if (magazineMap.containsKey(key).not() || magazineMap[key]!! < value) {
                return false
            }
        }
        return true
    }
}
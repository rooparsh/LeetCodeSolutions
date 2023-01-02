package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/detect-capital/
 */

fun main() {
    println(DetectCapital().detectCapitalUse("FlaG"))
}

class DetectCapital {
    fun detectCapitalUse(word: String): Boolean {
        return word.all { it.isUpperCase() } || word.drop(1).all { it.isLowerCase() }
    }
}
package two_weeks_study_plan.algorithm_1.day_4


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/reverse-words-in-a-string-iii/?envType=study-plan&id=algorithm-i
 */

fun main() {
    println(ReverseWordsInString().reverseWords("Let's take LeetCode contest"))
}

class ReverseWordsInString {
    fun reverseWords(s: String): String {
        return s.split(" ").joinToString(" ") { it.reversed() }
    }
}
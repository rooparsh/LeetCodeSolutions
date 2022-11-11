package two_weeks_study_plan.alogrithm.algorithm_1.day_4


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/reverse-string/?envType=study-plan&id=algorithm-i
 */

fun main() {
    val array = charArrayOf('h', 'e', 'l', 'l', 'o')
    ReverseString().reverseString2(array)
    println(array.joinToString())
}

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var startIdx = 0
        var endIdx = s.size - 1

        while (startIdx < endIdx) {
            s[startIdx] = s[endIdx].also { s[endIdx] = s[startIdx] }
            startIdx++
            endIdx--
        }
    }

    fun reverseString2(s: CharArray): Unit {
        val lastIndex = s.lastIndex

        for (i in 0..lastIndex / 2) {
            s[i] = s[lastIndex - i].also { s[lastIndex - i] = s[i] }
        }
    }
}
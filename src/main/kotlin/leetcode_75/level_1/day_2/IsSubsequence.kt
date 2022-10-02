package leetcode_75.level_1.day_2


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/is-subsequence/
 */

fun main() {
    println(IsSubsequence().isSubsequence("abc", "ahbgdc"))
}

class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0

        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) i++
            j++
        }

        return i == s.length
    }
}
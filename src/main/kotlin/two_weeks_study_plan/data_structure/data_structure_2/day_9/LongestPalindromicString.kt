package two_weeks_study_plan.data_structure.data_structure_2.day_9

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/longest-palindromic-substring/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(LongestPalindromicString().longestPalindrome("babab"))
}

class LongestPalindromicString {
    fun longestPalindrome(s: String): String {
        if (s.isBlank() || s.length == 1) return s
        var windowSize = s.length
        var from: Int
        var to: Int
        while (windowSize > 1) {
            from = 0
            to = windowSize - 1
            while (to < s.length) {
                if (isPalindrome(s, from, to)) return s.substring(from..to)
                from++
                to++
            }
            windowSize--
        }
        return s[0].toString()
    }

    private fun isPalindrome(s: String, from: Int, to: Int): Boolean {
        var left = from
        var right = to
        while (left < right) if (s[left++] != s[right--]) return false
        return true
    }
}
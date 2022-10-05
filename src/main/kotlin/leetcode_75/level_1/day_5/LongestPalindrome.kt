package leetcode_75.level_1.day_5

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/longest-palindrome/?envType=study-plan&id=level-1
 */

fun main() {
    print(LongestPalindrome().longestPalindrome("abccccdd"))
}

class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val map = s.split("").groupingBy { it }.eachCount()

        var count = 0

        map.values.forEach {
            count += it % 2
        }

        return if (count > 1) {
            s.length - count + 1
        } else {
            s.length
        }
    }


    fun longestPalindrome2(s: String): Int {
        return minOf(s.length,
            1 + s
                .groupingBy { it }
                .eachCount()
                .map { (key, value) -> value / 2 * 2 }
                .sum())
    }
}
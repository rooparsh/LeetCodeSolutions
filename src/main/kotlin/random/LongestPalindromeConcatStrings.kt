package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
 */

fun main() {
    println(
        LongestPalindromeConcatStrings().longestPalindrome(
            arrayOf(
                "em", "pe", "mp", "ee", "pp", "me", "ep", "em", "em", "me"
            )
        )
    )
}

class LongestPalindromeConcatStrings {
    fun longestPalindrome(words: Array<String>): Int {
        val map = mutableMapOf<String, Int>()
        var ans = 0
        var count = 0
        for (word in words) {
            val reversed = word.reversed()
            if (reversed == word) {
                if (map.containsKey(reversed)) {
                    count--
                    ans += 4
                    map.remove(reversed)
                } else {
                    count++
                    map[reversed] = 1
                }
            } else {
                var v = map.getOrDefault(reversed, 0)
                if (v == 0) {
                    var k = map.getOrDefault(word, 0)
                    k++
                    map[word] = k
                } else {
                    v--
                    ans += 4
                    if (v == 0) {
                        map.remove(reversed)
                    } else {
                        map[reversed] = v
                    }
                }
            }
        }
        return if (count > 0) ans + 2 else ans
    }
}
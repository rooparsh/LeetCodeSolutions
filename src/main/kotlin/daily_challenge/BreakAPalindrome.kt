package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/break-a-palindrome/
 */

fun main() {
    print(BreakAPalindrome().breakPalindrome("aa"))

}

class BreakAPalindrome {
    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length == 1) return ""

        val duplicate = palindrome.toCharArray()
        var countA = 0
        for (i in 0 until duplicate.size / 2) {
            if (duplicate[i] != 'a') {
                duplicate[i] = 'a'
                break
            } else {
                countA++
            }
        }

        if (countA == palindrome.length / 2) {
            duplicate[duplicate.lastIndex] = 'b'
        }
        return duplicate.joinToString("")
    }
}
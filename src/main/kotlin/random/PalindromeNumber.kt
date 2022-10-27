package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/palindrome-number/
 */

fun main() {
    print(PalindromeNumber().isPalindrome(9))
}

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var temp = x
        var reverse = 0
        while (temp != 0) {
            val remainder = temp % 10
            reverse = (reverse * 10) + remainder
            temp /= 10
        }
        return x == reverse
    }
}
package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */

fun main() {
    print(EquivalentStrings().arrayStringsAreEqual(arrayOf("ab", "c"), arrayOf("a", "bc")))
}

class EquivalentStrings {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean =
        word1.joinToString("") == word2.joinToString("")
}
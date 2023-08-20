package leetcode_75.daily.array

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(mergeAlternately("abc", "pqr"))
}

fun mergeAlternately(word1: String, word2: String): String {
    var pointer1 = 0
    var pointer2 = 0

    val finalString = StringBuilder()

    while (pointer1 < word1.length || pointer2 < word2.length) {
        if (pointer1 < word1.length) {
            finalString.append(word1[pointer1])
            pointer1++
        }
        if (pointer2 < word2.length) {
            finalString.append(word2[pointer2])
            pointer2++
        }
    }

    return finalString.toString()
}
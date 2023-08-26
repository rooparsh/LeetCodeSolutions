package leetcode_75.daily.sliding_window

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(maxVowels("weallloveyou", 7))
}

fun maxVowels(s: String, k: Int): Int {
    fun Char.isVowel(): Boolean {
        return this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u'
    }

    fun valueOf(c: Char): Int {
        return if (c.isVowel()) 1 else 0
    }

    var value = 0
    for (i in 0 until k) {
        value += valueOf(s[i])
    }
    var maxValue = value
    for (i in k until s.length) {
        value = value - valueOf(s[i - k]) + valueOf(s[i])
        maxValue = Math.max(value, maxValue)
    }
    return maxValue
}
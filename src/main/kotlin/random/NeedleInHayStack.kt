package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
fun main() {
    println(strStr("leetcode","leeto"))
}

fun strStr(haystack: String, needle: String): Int = haystack.indexOf(needle)
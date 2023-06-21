package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/longest-common-prefix/description/
 */

fun main() {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var result = ""
    if (strs.any { it.isEmpty() }) return result
    var list = strs.toList()
    var curr = list.first().first()
    while (list.all { it.first() == curr }) {
        result += curr
        list = list.map { it.drop(1) }
        if (list.any { it.isEmpty() }) return result
        curr = list.first().first()
    }
    return result
}
package leetcode_75.daily.dp

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/longest-common-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val result = LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace")
    println(result)
}

class LongestCommonSubsequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val array = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            for (j in 1..n) {
                if (text1[i - 1] == text2[j - 1]) {
                    array[i][j] = array[i - 1][j - 1] + 1
                } else {
                    array[i][j] = maxOf(array[i - 1][j], array[i][j - 1])
                }
            }
        }
        return array[m][n]
    }
}
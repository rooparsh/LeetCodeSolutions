package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/perfect-squares/
 */

fun main() {
    print(LeastPerfectSquares().numSquares(12))
}

class LeastPerfectSquares {
    fun numSquares(n: Int): Int {
        val dp = Array<Int>(n + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 1 until n + 1) {
            var j = 1
            while (j * j <= i) {
                dp[i] = minOf(dp[i], dp[i - j * j] + 1)
                j++
            }
        }
        return dp[n]
    }
}
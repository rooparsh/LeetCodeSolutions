package random

import kotlin.math.min

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 */
fun main() {
    print(MinimumDifficultyOfJobSchedule().minDifficulty(intArrayOf(6, 5, 4, 3, 2, 1), 2))
}

class MinimumDifficultyOfJobSchedule {
    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        val n = jobDifficulty.size
        if (d > n) return -1

        val dp = Array(d) { IntArray(n) { Int.MAX_VALUE } }

        for (i in dp[0].indices) {
            dp[0][i] = jobDifficulty.slice(0..i).maxOrNull()!!
            println(dp[0].joinToString())
        }

        for (day in 1 until d) {
            for (i in dp[day].indices) {
                for (j in 0 until i) {
                    if (dp[day - 1][j] != Int.MAX_VALUE)
                        dp[day][i] = min(dp[day][i], dp[day - 1][j] + jobDifficulty.slice(j + 1..i).maxOrNull()!!)
                }
            }
        }

        return dp[d - 1][n - 1]
    }
}
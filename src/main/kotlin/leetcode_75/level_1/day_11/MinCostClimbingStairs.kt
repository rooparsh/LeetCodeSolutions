package leetcode_75.level_1.day_11

import kotlin.math.min

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/min-cost-climbing-stairs/?envType=study-plan&id=level-1
 */

fun main() {
    print(MinCostClimbingStairs().minCostClimbingStairs(intArrayOf(10, 15, 20)))
}

class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = MutableList(cost.size) { 0 }
        dp[0] = cost[0]
        dp[1] = cost[1]
        for (x in 2 until cost.size) {
            dp[x] = Math.min(dp[x - 1] + cost[x], dp[x - 2] + cost[x])
        }

        return min(dp[cost.size - 1], dp[cost.size - 2])
    }
}
package leetcode_75.daily.dp

import kotlin.math.max

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=study-plan-v2&envId=leetcode-75
 *
 */
fun main() {
    println(BuySellStocks().maxProfit(intArrayOf(1, 3, 2, 8, 4, 9), 2))
}

class BuySellStocks {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        if (prices.size <= 1) return 0
        var hold = 0
        var free = 0
        for (i in prices.size - 1 downTo 0) {
            free = max(free, hold - prices[i])
            hold = max(hold, free + prices[i] - fee)
        }
        return free
    }
}
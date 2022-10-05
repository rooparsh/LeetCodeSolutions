package two_weeks_study_plan.data_structure_1.day_3

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan&id=data-structure-i
 */

fun main() {

    val array = intArrayOf(7, 1, 5, 3, 6, 4)

    println(BestTimeToBuyAndSellStocks().maxProfit(array))

}


class BestTimeToBuyAndSellStocks {
    fun maxProfit(prices: IntArray): Int {
        prices.foldIndexed(prices[0]) { i, min, n ->
            prices[i] = n - min
            if (n < min) n else min
        }

        return prices.maxOrNull() ?: 0
    }
}
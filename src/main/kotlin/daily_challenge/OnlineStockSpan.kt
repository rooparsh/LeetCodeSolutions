package daily_challenge

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/online-stock-span/
 */

class OnlineStockSpan {

    private val stack = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var result = 1

        while (stack.isNotEmpty() && stack.peek().first <= price) {
            result += stack.pop().second
        }
        stack.push(Pair(price, result))
        return result
    }
}
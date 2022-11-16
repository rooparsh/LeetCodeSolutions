package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/guess-number-higher-or-lower/
 */

fun main() {
    println(GuessGame().guessNumber(120))
}

class GuessGame {

    private val pickedNumber = 6

    private fun guess(num: Int): Int {
        return when {
            num > pickedNumber -> -1
            num < pickedNumber -> 1
            else -> 0
        }
    }

    fun guessNumber(n: Int): Int {
        var start = 1
        var end = n

        while (start <= end) {
            val mid = start + (end - start) / 2
            when (guess(mid)) {
                1 -> start = mid + 1
                -1 -> end = mid - 1
                0 -> return mid
            }
        }

        return 0
    }
}
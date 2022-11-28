package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 */

fun main() {
    print(
        FindPlayersWithZeroOneLoss().findWinners2(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 6),
                intArrayOf(5, 6),
                intArrayOf(5, 7),
                intArrayOf(4, 5),
                intArrayOf(4, 8),
                intArrayOf(4, 9),
                intArrayOf(10, 4),
                intArrayOf(10, 9),
            )
        )
    )
}

class FindPlayersWithZeroOneLoss {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val tally = mutableMapOf<Int, Pair<Int, Int>>()
        matches.forEach { array ->
            val winner = array[0]
            val loser = array[1]
            val prevWinnerTally = tally.getOrDefault(winner, Pair(0, 0))
            val prevLoserTally = tally.getOrDefault(loser, Pair(0, 0))
            tally[winner] = Pair(prevWinnerTally.first + 1, prevWinnerTally.second)
            tally[loser] = Pair(prevLoserTally.first, prevLoserTally.second + 1)
        }

        return listOf(
            tally.filter { it.value.second == 0 }.keys.sorted(),
            tally.filter { it.value.second == 1 }.keys.sorted()
        )
    }

    fun findWinners2(matches: Array<IntArray>): List<List<Int>> {
        val tally = mutableMapOf<Int, Int>()
        matches.forEach { match ->
            val winner = match[0]
            val loser = match[1]

            tally[winner] = tally.getOrDefault(winner, 0)
            tally[loser] = tally.getOrDefault(loser, 0) + 1
        }

        return listOf(
            tally.filter { it.value == 0 }.keys.sorted(),
            tally.filter { it.value == 1 }.keys.sorted()
        )
    }
}
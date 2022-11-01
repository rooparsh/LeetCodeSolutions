package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/where-will-the-ball-fall/
 */

fun main() {
    println(
        FindBall().findBall(
            arrayOf(
                intArrayOf(1, 1, 1, -1, -1),
                intArrayOf(1, 1, 1, -1, -1),
                intArrayOf(-1, -1, -1, 1, 1),
                intArrayOf(1, 1, 1, 1, -1),
                intArrayOf(-1, -1, -1, -1, -1),
            )
        ).joinToString()
    )
}

class FindBall {
    fun findBall(grid: Array<IntArray>): IntArray {
        val n = grid.first().size
        val outcomes = IntArray(n)
        fun isGoingToHitRightWall(i: Int, j: Int) = grid[i][j] == 1 && j == n - 1
        fun isGoingToHitLeftWall(i: Int, j: Int) = grid[i][j] == -1 && j == 0
        fun isGoingToGetStuckInV(i: Int, j: Int) =
            (grid[i][j] == 1 && grid[i][j] != grid[i][j + 1]) || (grid[i][j] == -1 && grid[i][j] != grid[i][j + -1])

        for (ball in 0 until n) {
            var j = ball
            for (i in grid.indices) {
                if (isGoingToHitRightWall(i, j) || isGoingToHitLeftWall(i, j) || isGoingToGetStuckInV(i, j)) {
                    j = -1
                    break
                }
                j = if (grid[i][j] == 1) j + 1 else j - 1
            }
            outcomes[ball] = j
        }
        return outcomes
    }
}
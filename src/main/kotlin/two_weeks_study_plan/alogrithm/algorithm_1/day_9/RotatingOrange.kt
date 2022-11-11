package two_weeks_study_plan.alogrithm.algorithm_1.day_9

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/rotting-oranges/?envType=study-plan&id=algorithm-i
 */

fun main() {
    println(
        RotatingOrange().orangesRotting(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1)
            )
        )
    )
}

class RotatingOrange {
    fun orangesRotting(grid: Array<IntArray>): Int {
        fun inBounds(dx: Int, dy: Int): Boolean = dx >= 0 && dx < grid.size && dy >= 0 && dy < grid[0].size

        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)
        var minute = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        var freshes = 0

        // 1. First we add all rotten oranges to the queue
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 2) {
                    queue.add(Pair(i, j))
                } else if (grid[i][j] == 1) {
                    freshes++
                }
            }
        }


        // 2. Perform BFS on each rotten orange
        while (!queue.isEmpty()) {
            // For each rotten orange at current minute, we find all the adjancent fresh orange and queue them for next minute
            val currRottenSize = queue.size
            for (i in 0 until currRottenSize) {
                val curr = queue.removeFirst()
                for (k in dx.indices) {
                    val x = curr.first
                    val y = curr.second
                    if (inBounds(x + dx[k], y + dy[k]) && grid[x + dx[k]][y + dy[k]] == 1) {
                        // If adjacent is fresh orange, we set it to rotted, and we add it to the queue so that we can set its children to rotten in the next minute
                        queue.add(Pair(x + dx[k], y + dy[k]))
                        // Rotten the adjacent
                        grid[x + dx[k]][y + dy[k]] = 2
                        // Update number of remaining freshes oranges
                        freshes--
                    }
                }
            }
            if (!queue.isEmpty()) {
                minute++
            }
        }

        // 3. Check If there are any remaining fresh orange after we rotten all posibles adjacents
        return if (freshes > 0) -1 else minute

    }
}
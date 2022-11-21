package daily_challenge

import util.directions
import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 */

class NearestExitFromMaze {

    companion object {
        private const val BLOCKED = '+'
    }

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val rows = maze.size
        val col = maze[0].size

        val queue = LinkedList<IntArray>()
        queue.offer(entrance)
        maze[entrance[0]][entrance[1]] = BLOCKED


        var steps = 0

        while (queue.isNotEmpty()) {
            steps++

            var n = queue.size
            while (n > 0) {
                val current = queue.poll()

                directions.forEach { direction ->

                    val x = current[0] + direction.x
                    val y = current[1] + direction.y

                    if ((x in 0 until rows)
                        && (y in 0 until col)
                        && maze[x][y] != BLOCKED
                    ) {

                        if (x == 0 || x == rows - 1 || y == 0 || y == col - 1) return steps

                        maze[x][y] = BLOCKED
                        queue.offer(intArrayOf(x, y))
                    }


                }

                n--

            }
        }


        return -1

    }
}
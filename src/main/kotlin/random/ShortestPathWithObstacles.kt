package random

import java.util.*

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */

fun main() {
    print(
        ShortestPathWithObstacles().shortestPath(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 1),
                intArrayOf(0, 0, 0)
            ),
            1
        )
    )
}

class ShortestPathWithObstacles {
    private data class Node(val x: Int, val y: Int, val obs: Int, val dist: Int)

    private val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val queue = LinkedList<Node>()
        val visited = Array(grid.size) { Array(grid[0].size) { BooleanArray(grid[0].size * grid.size + 1) } }

        queue.offer(Node(0, 0, k, 0))

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            val x = node.x
            val y = node.y
            val obs = node.obs
            val dist = node.dist

            if (visited[x][y][obs]) continue

            visited[x][y][obs] = true

            if (x == grid.lastIndex && y == grid[0].lastIndex) {
                return dist
            }

            dirs.forEach { dir ->
                val x1 = x + dir[0]
                val y1 = y + dir[1]

                if (x1 < 0 || x1 >= grid.size || y1 < 0 || y1 >= grid[0].size) return@forEach

                if (grid[x1][y1] == 1 && obs > 0) {
                    queue.offer(Node(x1, y1, obs - 1, dist + 1))
                } else if (grid[x1][y1] == 0) {
                    queue.offer(Node(x1, y1, obs, dist + 1))
                }
            }
        }
        return -1
    }
}
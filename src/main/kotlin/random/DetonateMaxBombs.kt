package random

import kotlin.math.sqrt

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/detonate-the-maximum-bombs/
 */
fun main() {
    println(maximumDetonation(arrayOf(intArrayOf(2, 1, 3), intArrayOf(6, 1, 4))))
}

fun distance(a: IntArray, b: IntArray): Double {
    val dx = (a[0] - b[0]).toDouble()
    val dy = (a[1] - b[1]).toDouble()
    return sqrt((dx * dx) + (dy * dx))
}

fun maximumDetonation(bombs: Array<IntArray>): Int {
    val size = bombs.size
    var visited = BooleanArray(size) { false }

    fun dfs(id: Int): Int {
        if (visited[id]) return 0

        visited[id] = true

        var count = 1
        val curr = bombs[id]

        for (i in 0 until size) {
            if (id == i) continue
            if (visited[i]) continue
            val next = bombs[i]

            if (distance(curr, next) <= curr[2].toDouble()) {
                count += dfs(i)
            }
        }

        return count
    }


    var result = 0

    for (i in 0 until size) {
        visited = BooleanArray(size) { false }
        result = result.coerceAtLeast(dfs(i))
    }


    return result
}
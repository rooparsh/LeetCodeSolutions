package leetcode_75.daily.dfs

import kotlin.math.abs


/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(
        MinReorderRoute().minReorder(
            6,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(4, 0),
                intArrayOf(4, 5),
            )
        )
    )
}

class MinReorderRoute {
    private lateinit var edges: HashMap<Int, ArrayList<Int>>
    private lateinit var visited: HashSet<Int>

    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        edges = getEdgesFrom(connections)
        visited = hashSetOf(0)
        return dfs(0)
    }

    private fun dfs(node: Int): Int {
        var ans = 0
        for (neighbor in edges[node] ?: arrayListOf()) {
            if (visited.contains(abs(neighbor))) continue
            visited.add(abs(neighbor))
            if (neighbor > 0) ans++
            ans += dfs(abs(neighbor))
        }
        return ans
    }

    private fun getEdgesFrom(connections: Array<IntArray>): HashMap<Int, ArrayList<Int>> {
        val edges = HashMap<Int, ArrayList<Int>>()
        for ((src, dst) in connections) {
            edges.computeIfAbsent(src) { arrayListOf<Int>() }.add(dst)
            edges.computeIfAbsent(dst) { arrayListOf<Int>() }.add(-src)
        }
        return edges
    }
}
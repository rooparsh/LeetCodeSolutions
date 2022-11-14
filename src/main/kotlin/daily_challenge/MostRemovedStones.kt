package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */

fun main() {
    println(
        MostRemovedStones().removeStones(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1),
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(2, 1),
                intArrayOf(2, 2),
            )
        )
    )
}

class MostRemovedStones {

    fun removeStones(stones: Array<IntArray>): Int {

        val xs: MutableMap<Int, MutableList<IntArray>> = mutableMapOf()
        val ys: MutableMap<Int, MutableList<IntArray>> = mutableMapOf()
        val processed: MutableSet<Pair<Int, Int>> = mutableSetOf()
        var c = 0


        stones.forEach {
            xs[it[0]] = xs.getOrDefault(it[0], mutableListOf())
            ys[it[1]] = ys.getOrDefault(it[1], mutableListOf())
            xs[it[0]]?.add(it)
            ys[it[1]]?.add(it)
        }


        fun dfs(x: Int, y: Int) {
            xs[x]?.forEach {
                if (!processed.contains(Pair(it[0], it[1]))) {
                    processed.add(Pair(it[0], it[1]))
                    dfs(it[0], it[1])
                }
            }
            ys[y]?.forEach {
                if (!processed.contains(Pair(it[0], it[1]))) {
                    processed.add(Pair(it[0], it[1]))
                    dfs(it[0], it[1])
                }
            }
        }

        stones.forEach {
            if (!processed.contains(Pair(it[0], it[1]))) {
                c += 1
                processed.add(Pair(it[0], it[1]))
                dfs(it[0], it[1])
            }
        }

        return stones.size - c
    }
}
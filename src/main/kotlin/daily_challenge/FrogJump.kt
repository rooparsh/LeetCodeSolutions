package daily_challenge

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/frog-jump/
 */

fun main() {
    println(canCross(intArrayOf(0, 1, 3, 5, 6, 8, 12, 17)))
}

fun canCross(stones: IntArray): Boolean {
    val map = mutableMapOf<Int, MutableSet<Int>>()

    map[stones[0] + 1] = mutableSetOf(1)
    for (i in 1 until stones.size - 1) {
        val stone = stones[i]
        map[stone]?.let { set ->
            set.forEach { k ->
                for (j in k - 1..k + 1) {
                    map[stone + j] = map.getOrDefault(stone + j, mutableSetOf<Int>()).also { it.add(j) }
                }
            }
        }
    }

    return map.contains(stones[stones.size - 1])
}
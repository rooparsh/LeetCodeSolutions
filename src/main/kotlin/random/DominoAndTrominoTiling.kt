package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/domino-and-tromino-tiling/description/
 */

fun main() {
    println(numTilings(5))
}

fun numTilings(n: Int): Int {
    if (n < 3) return n

    val array = longArrayOf(1, 2, 5)

    for (i in 3 until n) {
        val temp = array[0]
        array[0] = array[1]
        array[1] = array[2]
        array[2] = ((array[2] * 2 + temp) % 1000000007)
    }

    return array[2].toInt()
}
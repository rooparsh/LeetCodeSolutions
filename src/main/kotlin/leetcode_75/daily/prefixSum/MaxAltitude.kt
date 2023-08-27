package leetcode_75.daily.prefixSum

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2)))
}

fun largestAltitude(gain: IntArray): Int {
    val array = mutableListOf<Int>()
    array.add(0)

    for (pointer in gain.indices) {
        array.add(pointer + 1, array[pointer] + gain[pointer])
    }
    return array.maxOrNull() ?: 0
}

fun largestAltitude2(gain: IntArray): Int {
    var current = 0
    var max = 0

    for (i in gain.indices) {
        current += gain[i]
        max = current.coerceAtLeast(max)
    }

    return max
}

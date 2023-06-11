package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */

fun main() {
    println(
            checkStraightLine(
                    arrayOf(
                            intArrayOf(1, 2),
                            intArrayOf(2, 3),
                            intArrayOf(3, 4),
                            intArrayOf(4, 5),
                            intArrayOf(6, 7),
                    )
            )
    )
}

fun getSlope(coord2: IntArray, coord1: IntArray): Double {

    val dx = coord2[0] - coord1[0]
    val dy = coord2[1] - coord1[1]

    if (dx == 0) return Double.MAX_VALUE

    return dy.toDouble() / dx.toDouble()
}

fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    if (coordinates.size <= 2) return true

    val slope = getSlope(coordinates[1], coordinates[0])

    for (i in 2 until coordinates.size) {
        val currentSlope = getSlope(coordinates[i], coordinates[i - 1])
        if (currentSlope != slope) return false
    }

    return true
}
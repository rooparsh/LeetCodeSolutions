package leetcode_75.daily.mapSet

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(
        equalPairs(
            arrayOf(
                intArrayOf(3, 2, 1),
                intArrayOf(1, 7, 6),
                intArrayOf(2, 7, 7)
            )
        )
    )
}

fun equalPairs(grid: Array<IntArray>): Int {
    var count = 0
    val size = grid.size

    val map = hashMapOf<String, Int>()

    for (row in grid) {
        val rowString = row.contentToString()
        map[rowString] = 1 + map.getOrDefault(rowString, 0)
    }


    for (col in 0 until size) {
        val column = IntArray(size)
        for (row in 0 until size) {
            column[row] = grid[row][col]
        }

        count += map.getOrDefault(column.contentToString(), 0)
    }

    return count
}
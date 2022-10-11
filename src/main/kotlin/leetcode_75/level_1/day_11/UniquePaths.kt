package leetcode_75.level_1.day_11

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/unique-paths/?envType=study-plan&id=level-1
 */

fun main() {
    print(UniquePaths().uniquePaths(3, 7))
}

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val (short, long) = if (m < n) m to n else n to m

        var previousRow = IntArray(short)

        repeat(long) {
            val currentRow = IntArray(short)
            currentRow[0] = 1
            for (i in 1..currentRow.lastIndex) {
                currentRow[i] = currentRow[i - 1] + previousRow[i]
            }
            previousRow = currentRow
        }

        return previousRow.last()
    }
}
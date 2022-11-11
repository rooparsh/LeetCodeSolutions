package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/toeplitz-matrix/
 */

fun main() {
    print(
        ToeplitzMatrix().isToeplitzMatrix(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 1, 2, 3),
                intArrayOf(9, 5, 1, 2)
            )
        )
    )
}

class ToeplitzMatrix {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val rows = matrix.size
        val columns = matrix[0].size

        val map = mutableMapOf<Int, Int>()

        for (row in 0 until rows) {
            for (column in 0 until columns) {

                /*
                 * the idea is each diagonal has same difference
                 * [0,0], [1,1]...has diff 0
                 * [1,0], [2,1]... has diff 1
                 */

                val key = row - column

                if (map.containsKey(key)) {
                    if (map[key] != matrix[row][column]) return false
                } else {
                    map[key] = matrix[row][column]
                }
            }
        }
        return true
    }
}
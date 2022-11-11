package two_weeks_study_plan.data_structure.data_structure_2.day_4

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/search-a-2d-matrix-ii/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    val array = arrayOf(
        intArrayOf(1, 4, 7, 11, 15),
        intArrayOf(2, 5, 8, 12, 19),
        intArrayOf(3, 6, 9, 16, 22),
        intArrayOf(10, 13, 14, 17, 24),
        intArrayOf(18, 21, 23, 26, 30)
    )
    print(Search2dMatrix().searchMatrix(array, 100))
}

class Search2dMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var x = 0
        var y = matrix[0].lastIndex

        while (x <= matrix.lastIndex) {
            while (y >= 0) {
                if (target == matrix[x][y]) return true
                if (target > matrix[x][y]) break
                y--
            }
            x++
        }
        return false
    }
}
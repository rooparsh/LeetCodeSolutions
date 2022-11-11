package two_weeks_study_plan.data_structure.data_structure_1.day_5


/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan&id=data-structure-i
 */

fun main() {

    val array = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )

    println(Search2dMatrix().searchMatrix(array, 3))

}

class Search2dMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        if (matrix.isEmpty() || matrix[0].isEmpty()) return false

        val rows = matrix.size
        val columns = matrix[0].size

        if (target < matrix[0][0] || target > matrix[rows - 1][columns - 1]) return false

        var l = 0
        var r = rows * columns - 1

        while (l <= r) {
            val mid = (l + r) / 2
            val temp = matrix[mid / columns][mid % columns] - target

            when {
                temp < 0 -> l = mid + 1
                temp > 0 -> r = mid - 1
                else -> return true
            }
        }

        return matrix[l / columns][l % columns] == target

    }
}
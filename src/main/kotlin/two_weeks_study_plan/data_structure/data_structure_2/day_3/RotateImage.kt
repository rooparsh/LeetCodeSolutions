package two_weeks_study_plan.data_structure.data_structure_2.day_3

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/rotate-image/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    val image = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    RotateImage().rotate(image)
    print(image.joinToString())
}

class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        val rows = matrix.size

        for (i in 0 until rows) {
            for (j in 0 until i) {
                matrix[i][j] = matrix[j][i].also { matrix[j][i] = matrix[i][j] }
            }
        }

        for (element in matrix)
            element.reverse()
    }
}
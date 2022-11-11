package two_weeks_study_plan.data_structure.data_structure_1.day_5


/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/valid-sudoku/?envType=study-plan&id=data-structure-i
 */

fun main() {

    val array = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println(ValidSudoku().isValidSudoku(array))

}

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val number = board[i][j]
                if (number != '.') {
                    if (!seen.add("$number in row $i") ||
                        !seen.add("$number in column $j") ||
                        !seen.add("$number in block ${i / 3}-${j / 3}")
                    ) return false

                }
            }
        }

        return true
    }
}
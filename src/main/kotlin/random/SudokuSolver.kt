package random

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/sudoku-solver/
 */

class SudokuSolver {

    private val EMPTY_CELL = '.'

    private fun solve(board: Array<CharArray>): Boolean {
        for (row in 0 until 9) {
            for (col in 0 until 9) {
                if (board[row][col] == EMPTY_CELL) {
                    for (num in 1..9) {
                        if (isSafe(row, col, board, num.digitToChar())) {
                            board[row][col] = num.digitToChar()
                            if (solve(board)) {
                                return true
                            } else {
                                board[row][col] = EMPTY_CELL
                            }
                        }
                    }

                    return false
                }
            }
        }

        return true
    }

    private fun isSafe(row: Int, col: Int, board: Array<CharArray>, num: Char): Boolean {
        for (i in 0 until 9) {
            if (board[row][i] == num) return false
            if (board[i][col] == num) return false

            val r = 3 * (row / 3) + i / 3
            val c = 3 * (col / 3) + i % 3

            if (board[r][c] == num) return false
        }
        return true
    }

    fun solveSudoku(board: Array<CharArray>) {
        solve(board)
    }


}
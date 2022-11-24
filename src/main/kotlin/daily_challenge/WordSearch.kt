package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/word-search/description/
 */

class WordSearch {

    private fun isSafe(board: Array<CharArray>, char: Char, x: Int, y: Int) =
        x in board.indices && y in board[x].indices && board[x][y] == char

    private fun backtrack(board: Array<CharArray>, word: String, index: Int, x: Int, y: Int): Boolean {
        board[x][y] = '.'
        if (index == word.lastIndex) return true
        val nextIndex = index + 1
        return when {
            isSafe(board, word[nextIndex], x - 1, y) && backtrack(board, word, nextIndex, x - 1, y) -> true // left
            isSafe(board, word[nextIndex], x + 1, y) && backtrack(board, word, nextIndex, x + 1, y) -> true // right
            isSafe(board, word[nextIndex], x, y - 1) && backtrack(board, word, nextIndex, x, y - 1) -> true // top
            isSafe(board, word[nextIndex], x, y + 1) && backtrack(board, word, nextIndex, x, y + 1) -> true // bottom
            else -> {
                board[x][y] = word[index]
                false
            }
        }
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == word[0] && backtrack(board, word, 0, i, j)) return true
            }
        }
        return false
    }
}
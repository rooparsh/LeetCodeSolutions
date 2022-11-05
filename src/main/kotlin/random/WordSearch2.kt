package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/k-closest-points-to-origin/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    println(
        WordSearch2().findWords(
            arrayOf(
                charArrayOf('o', 'a', 'a', 'n'),
                charArrayOf('e', 't', 'a', 'e'),
                charArrayOf('i', 'h', 'k', 'r'),
                charArrayOf('i', 'f', 'l', 'v'),
            ),
            arrayOf("oath", "pea", "eat", "rain")
        ).joinToString()
    )
}

class WordSearch2 {


    data class Word(val char: Char) {
        val map = mutableMapOf<Char, Word>()
        var isCompleted = false
    }


    private val ans = mutableSetOf<String>()
    private val root = Word('#')
    lateinit var board: Array<CharArray>

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        if (board.isEmpty() || board[0].isEmpty()) return ans.toList()
        this.board = board
        for (word in words) {
            var parent = root
            for (char in word) {
                var node = parent.map[char]
                if (node == null) {
                    node = Word(char)
                    parent.map[char] = node
                }
                parent = node
            }
            parent.isCompleted = true
        }
        val builder = StringBuilder()
        for (x in board.indices) {
            for (y in board[0].indices) {
                val curChar = board[x][y]
                builder.clear()
                getWords(x, y, root.map[curChar], builder)
            }
        }
        return ans.toList()
    }

    private fun getWords(x: Int, y: Int, node: Word?, builder: StringBuilder) {
        if (node == null || board[x][y] == '$') return
        val curChar = board[x][y]
        board[x][y] = '$'
        builder.append(curChar)
        if (node.isCompleted) ans.add(builder.toString())

        if (isValid(x + 1, y))
            getWords(x + 1, y, node.map[board[x + 1][y]], builder)
        if (isValid(x - 1, y))
            getWords(x - 1, y, node.map[board[x - 1][y]], builder)
        if (isValid(x, y + 1))
            getWords(x, y + 1, node.map[board[x][y + 1]], builder)
        if (isValid(x, y - 1))
            getWords(x, y - 1, node.map[board[x][y - 1]], builder)

        builder.deleteCharAt(builder.lastIndex)

        board[x][y] = curChar
    }

    private fun isValid(x: Int, y: Int): Boolean {
        return x >= 0 && y >= 0 && x < board.size && y < board[0].size
    }
}


package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/implement-trie-prefix-tree/
 */

fun main() {
    val trie = ImplementTrie()
    trie.insert("apple")
    println(trie.search("apple"))

    println(trie.search("app"))

    println(trie.startsWith("app"))

    trie.insert("app")
    println(trie.search("app"))

}

class ImplementTrie {

    internal data class TrieNode(
        val children: Array<TrieNode?> = Array(26) { null },
        var isTerminalNode: Boolean = false
    )

    private val root = TrieNode()
    fun insert(word: String) {
        var temp = root
        word.forEach {
            val index = it - 'a'
            val node = temp.children[index] ?: TrieNode()
            temp.children[index] = node
            temp = node
        }

        temp.isTerminalNode = true
    }

    fun search(word: String): Boolean {
        return contains(word, true)
    }

    fun startsWith(prefix: String): Boolean {
        return contains(prefix, false)
    }

    private fun contains(word: String, fullMatch: Boolean): Boolean {
        var temp = root
        word.forEachIndexed { count, char ->
            val index = char - 'a'
            temp.children[index]?.let {
                if (fullMatch && it.isTerminalNode.not() && count == word.lastIndex) return false
                temp = it
            } ?: return false
        }

        return true
    }
}
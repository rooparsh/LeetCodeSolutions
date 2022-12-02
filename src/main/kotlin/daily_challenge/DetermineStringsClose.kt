package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/determine-if-two-strings-are-close/
 */


fun main() {
    print(DetermineStringsClose().closeStrings("abc", "cab"))
}

class DetermineStringsClose {
    fun closeStrings(word1: String, word2: String): Boolean {
        val (g1, g2) = word1.groupBy { it } to word2.groupBy { it }
        return g1.keys == g2.keys && g1.map { it.value.size }.sorted() == g2.map { it.value.size }.sorted()
    }
}
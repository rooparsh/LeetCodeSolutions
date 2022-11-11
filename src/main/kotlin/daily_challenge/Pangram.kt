package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */

fun main() {
    print(Pangram().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
}

class Pangram {
    fun checkIfPangram(sentence: String): Boolean {
        return sentence.toList().distinct().size == 26
    }
}
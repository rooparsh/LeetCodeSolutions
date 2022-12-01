package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */

fun main() {
    print(StringHalvesAlike().halvesAreAlike("book"))
}

class StringHalvesAlike {

    private fun Char.isVowel(): Boolean = this.equals('a', true)
            || this.equals('e', true)
            || this.equals('i', true)
            || this.equals('o', true)
            || this.equals('u', true)

    fun halvesAreAlike(s: String): Boolean {
        val length = s.length
        val halfLength = length / 2
        val half1 = s.substring(0, halfLength)
        val half2 = s.substring(halfLength, length)

        var vowelsCount1 = 0
        var vowelsCount2 = 0

        half1.forEach { if (it.isVowel()) vowelsCount1++ }
        half2.forEach { if (it.isVowel()) vowelsCount2++ }

        return vowelsCount1 == vowelsCount2
    }
}
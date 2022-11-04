package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/reverse-vowels-of-a-string/
 */

fun main() {
    println(ReverseVowelsInString().reverseVowels("hello"))
}

class ReverseVowelsInString {
    private fun Char.isVowel(): Boolean = this.equals('a', true)
            || this.equals('e', true)
            || this.equals('i', true)
            || this.equals('o', true)
            || this.equals('u', true)

    fun reverseVowels(s: String): String {
        val array = s.toCharArray()
        var start = 0
        var end = array.size - 1

        while (start < end) {
            array[start].isDigit()
            if (array[start].isVowel() && array[end].isVowel()) {
                array[start] = array[end].also { array[end] = array[start] }
                start++
                end--
            } else if (array[start].isVowel() && array[end].isVowel().not()) {
                end--
            } else if (array[end].isVowel() && array[start].isVowel().not()) {
                start++
            } else {
                start++
                end--
            }
        }

        return array.joinToString("")
    }
}
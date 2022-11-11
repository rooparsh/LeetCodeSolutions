package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/integer-to-roman/
 */

fun main() {
    print(IntegerToRomanNumerals().intToRoman(3))
}

class IntegerToRomanNumerals {

    private val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    private val romanLiterals = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    fun intToRoman(num: Int): String {
        val stringBuilder = StringBuilder()

        var temp = num

        values.forEachIndexed { index, i ->
            while (temp >= i) {
                temp -= i
                stringBuilder.append(romanLiterals[index])
            }
        }

        return stringBuilder.toString()
    }
}
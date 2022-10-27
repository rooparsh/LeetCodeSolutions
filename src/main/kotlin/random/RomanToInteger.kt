package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/roman-to-integer/
 */

fun main() {
    print(RomanToInteger().romanToInt("LVIII"))
}

class RomanToInteger {

    private val map = mapOf(
        'M' to 1000,
        'D' to 500,
        'C' to 100,
        'L' to 50,
        'X' to 10,
        'V' to 5,
        'I' to 1,
    )

    fun romanToInt(s: String): Int {
        var sum = 0
        for (i in s.indices) {
            val number1 = map[s[i]]!!
            if (i + 1 < s.length) {
                val number2 = map[s[i + 1]]!!

                if (number1 < number2) {
                    sum -= number1
                } else {
                    sum += number1
                }
            } else {
                sum += number1
            }
        }

        return sum
    }
}
package daily_challenge

import java.util.*

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/basic-calculator/
 */

fun main() {
    print(BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"))
}

class BasicCalculator {
    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var partialResult = 0
        var number = 0
        var sign = 1
        for (char in s) {
            if (char.isDigit()) {
                number = number * 10 + Character.digit(char.toInt(), 10) // char.digitToInt()
            } else if (char == '+' || char == '-') {
                partialResult += number * sign
                number = 0
                sign = if (char == '-') -1 else 1
            } else if (char == '(') {
                stack.push(partialResult)
                stack.push(sign)
                partialResult = 0
                sign = 1
            } else if (char == ')') {
                partialResult += number * sign
                partialResult *= stack.pop()
                partialResult += stack.pop()
                number = 0
            }
        }
        return partialResult + number * sign
    }
}
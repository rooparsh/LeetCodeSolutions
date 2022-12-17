package daily_challenge

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */

fun main() {
    println(ReversePolishNotation().evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")))
}

class ReversePolishNotation {

    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()

        tokens.forEach { token ->
            when (token) {
                "+" -> {
                    val item2 = stack.pop()
                    val item1 = stack.pop()
                    val result = item1 + item2
                    stack.push(result)
                }

                "-" -> {
                    val item2 = stack.pop()
                    val item1 = stack.pop()
                    val result = item1 - item2
                    stack.push(result)
                }

                "*" -> {
                    val item2 = stack.pop()
                    val item1 = stack.pop()
                    val result = item1 * item2
                    stack.push(result)

                }

                "/" -> {
                    val item2 = stack.pop()
                    val item1 = stack.pop()
                    val result = item1 / item2
                    stack.push(result)
                }

                else -> {
                    stack.push(token.toInt())
                }
            }
        }

        return stack.pop()
    }
}
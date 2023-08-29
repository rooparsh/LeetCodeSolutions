package leetcode_75.daily.stack

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(decodeString("3[a]2[bc]"))
}

fun decodeString(s: String): String {
    val stack = Stack<Char>()

    s.forEach { ch ->
        when {
            ch != ']' -> stack.push(ch)
            else -> {
                var sb = StringBuilder()
                while (stack.peek() != '[') sb.insert(0, stack.pop())
                val sub = sb.toString()
                stack.pop()

                sb = StringBuilder()
                while (!stack.isEmpty() && stack.peek().isDigit()) sb.insert(0, stack.pop())
                val count = sb.toString().toInt()

                repeat(count) {
                    sub.forEach { stack.push(it) }
                }
            }
        }

    }
    val res = StringBuilder()
    while (!stack.isEmpty()) res.insert(0, stack.pop())
    return res.toString()
}
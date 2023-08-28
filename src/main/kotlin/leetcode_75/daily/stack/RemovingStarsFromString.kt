package leetcode_75.daily.stack

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
fun main() {
    println(removeStars("leet**cod*e"))
}

fun removeStars(s: String): String {
    val stack = Stack<Char>()
    val star = '*'

    s.forEach { char ->
        if (char == star) {
            if (stack.isNotEmpty()) {
                stack.pop()
            }
        } else {
            stack.push(char)
        }
    }
    return stack.joinToString("")
}
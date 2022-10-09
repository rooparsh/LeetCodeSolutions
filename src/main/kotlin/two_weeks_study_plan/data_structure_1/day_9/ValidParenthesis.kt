package two_weeks_study_plan.data_structure_1.day_9

import java.util.Stack

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/valid-parentheses/?envType=study-plan&id=data-structure-i
 */

fun main() {
    println(ValidParenthesis().isValid("()"))
}

class ValidParenthesis {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        s.toCharArray().forEach {
            when (it) {
                '{', '[', '(' -> stack.push(it)
                ')' -> if (stack.empty() || stack.peek() != '(') return false else stack.pop()
                '}' -> if (stack.empty() || stack.peek() != '{') return false else stack.pop()
                ']' -> if (stack.empty() || stack.peek() != '[') return false else stack.pop()
            }
        }
        return stack.isEmpty()
    }
}
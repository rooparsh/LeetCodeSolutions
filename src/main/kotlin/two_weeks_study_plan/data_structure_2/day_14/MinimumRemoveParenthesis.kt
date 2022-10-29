package two_weeks_study_plan.data_structure_2.day_14

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    println(MinimumRemoveParenthesis().minRemoveToMakeValid2("())()((("))
}

class MinimumRemoveParenthesis {
    fun minRemoveToMakeValid(s: String): String {
        val stack = Stack<Pair<Int, Char>>()

        s.toCharArray().forEachIndexed { index, char ->
            when (char) {
                '(' -> stack.push(Pair(index, char))
                ')' -> {
                    if (stack.isEmpty()) {
                        stack.push(Pair(index, char))
                    } else if (stack.peek().second == '(') {
                        stack.pop()
                    } else {
                        stack.push(Pair(index, char))
                    }
                }
            }
        }

        var validString = s

        while (stack.isNotEmpty()) {
            val invalidChar = stack.pop()
            validString = validString.replaceRange(invalidChar.first, invalidChar.first + 1, "#")

        }

        return validString.replace("#", "")
    }

    fun minRemoveToMakeValid2(s: String): String {
        val sb = StringBuilder(s)
        val stack = ArrayDeque<Int>()
        var offset = 0

        for (i in s.indices) {
            when (s[i]) {
                ')' -> {
                    if (stack.isEmpty()) sb.deleteCharAt(i - offset++)
                    else stack.removeLast()
                }

                '(' -> stack.offer(i)
            }
        }
        stack.forEach { sb.deleteCharAt(it - offset++) }

        return sb.toString()
    }
}
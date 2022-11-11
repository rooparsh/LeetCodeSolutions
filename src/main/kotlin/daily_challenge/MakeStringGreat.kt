package daily_challenge

import java.util.*

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/make-the-string-great/
 */

fun main() {
    println(MakeStringGreat().makeGood2("leEeetcode"))
}

class MakeStringGreat {

    fun makeGood2(s: String): String {
        val stack = Stack<Char>()
        val result = StringBuilder()


        s.forEach { char ->
            if (stack.isEmpty()) stack.push(char)
            else {
                val peekedItem = stack.peek().toInt()
                val charInt = char.toInt()
                if (peekedItem == charInt + 32 || charInt == peekedItem + 32) {
                    stack.pop()
                } else {
                    stack.push(char)
                }
            }
        }

        while (stack.isNotEmpty()) {
            result.append(stack.pop())
        }
        return result.reverse().toString()
    }

    fun makeGood(s: String): String {
        if (s.length == 1) return s
        val stringBuilder = StringBuilder()
        s.forEach { char ->
            val size = stringBuilder.length
            if (size > 0
                && stringBuilder[size - 1].equals(char, true)
                && ((stringBuilder[size - 1].isUpperCase() && char.isLowerCase()) || (stringBuilder[size - 1].isLowerCase() && char.isUpperCase()))
            ) {
                stringBuilder.deleteCharAt(size - 1)
            } else {
                stringBuilder.append(char)
            }
        }
        return stringBuilder.toString()
    }
}
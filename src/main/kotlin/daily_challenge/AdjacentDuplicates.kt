package daily_challenge

import java.util.*

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */

fun main() {
    println(AdjacentDuplicates().removeDuplicates("abbaca"))
}

class AdjacentDuplicates {
    fun removeDuplicates(s: String): String {
        if (s.isEmpty() || s.length == 1) return s
        val stack = Stack<Char>()

        s.forEach { char ->
            if (stack.isEmpty()) stack.push(char)
            else {
                if (stack.peek() == char) stack.pop()
                else stack.push(char)
            }
        }
        return stack.joinToString("")
    }
}
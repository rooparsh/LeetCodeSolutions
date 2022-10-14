package leetcode_75.level_1.day_14

import java.util.*

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/backspace-string-compare/?envType=study-plan&id=level-1
 */

fun main() {
    println(BackSpaceStringCompare().backspaceCompare("y#fo##f", "y#f#o##f"))
}

class BackSpaceStringCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
        val backSpace = '#'

        val firstBackStack = Stack<Char>()
        val secondBackStack = Stack<Char>()

        s.forEach {
            if (it == backSpace) {
                if (firstBackStack.isEmpty().not()) {
                    firstBackStack.pop()
                }
            } else firstBackStack.push(it)
        }

        t.forEach {
            if (it == backSpace) {
                if (secondBackStack.isEmpty().not()) {
                    secondBackStack.pop()
                }
            } else secondBackStack.push(it)
        }
        return firstBackStack == secondBackStack
    }
}
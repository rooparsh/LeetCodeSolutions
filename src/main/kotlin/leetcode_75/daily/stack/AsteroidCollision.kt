package leetcode_75.daily.stack

import java.util.*
import kotlin.math.abs

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(asteroidCollision(intArrayOf(-2, -1, 1, 2)).joinToString())
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = Stack<Int>()

    fun collideAsteroid(stack: Stack<Int>, new: Int) {
        if (stack.isNotEmpty()) {
            val existing = stack.peek()

            if (existing > 0 && new < 0) {
                if (new + existing == 0) {
                    stack.pop()
                } else {
                    if (abs(new) > abs(existing)) {
                        stack.pop()
                        collideAsteroid(stack, new)
                    }
                }
            } else {
                stack.push(new)
            }
        } else {
            stack.push(new)
        }
    }

    asteroids.forEach { collideAsteroid(stack, it) }


    return stack.toIntArray()

}
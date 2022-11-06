package random

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/orderly-queue/
 */

fun main() {
    println(OrderlyQueue().orderlyQueue("cba", 1))
}

class OrderlyQueue {
    fun orderlyQueue(s: String, k: Int): String {
        return when {
            k > 1 -> String(s.toCharArray().apply { sort() })
            else -> {
                val ss = s + s
                var res = ss.substring(0, s.length)
                for (start in 1 until s.length) {
                    res = minOf(res, ss.substring(start, start + s.length))
                }
                res
            }
        }
    }
}
package leetcode_75.daily.queue

import java.util.*

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val counter = RecentCounter()
    counter.ping(1)
    counter.ping(100)
    counter.ping(3001)
    counter.ping(3002)
}

class RecentCounter {
    val queue = LinkedList<Int>()
    fun ping(t: Int): Int {
        queue.addLast(t)

        while (queue.first < t - 3000) {
            queue.removeFirst()
        }

        return queue.size
    }

}

